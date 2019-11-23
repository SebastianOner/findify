import java.util.ArrayList;

public class SemanticWeb{
	private class Entry{
		String             word;
		ArrayList<Integer> references = new ArrayList<>();
		
		private Entry(String word){
			this.word = word;
		}
		
		private void addReference(int reference){
			references.add(reference);
		}
		
		private String getWord(){
			return word;
		}
		
		private ArrayList<Integer> getReferences(){
			return references;
		}
	}
	private Entry[]    entries    = new Entry[100];
	
	public SemanticWeb(String[][] input){
		int[] synonymPositions;
		for(String[] synonyms : input){
			synonymPositions = new int[synonyms.length];
			for(int i = 0; i < synonyms.length; ++i){
				synonymPositions[i] = findPosition(synonyms[i]);
				if(-1 == synonymPositions[i]){
					synonymPositions[i] = addEntry(synonyms[i]);
				}
			}
			for(int entryPosition : synonymPositions){
				for(int reference : synonymPositions){
					if(entryPosition != reference)
						entries[entryPosition].addReference(reference);
				}
			}
		}
	}
	
	public String[] getSynonyms(String string){
		ArrayList<Integer> synonymPositions =
				entries[findPosition(string)].getReferences();
		String[] synonyms = new String[synonymPositions.size()];
		for(int i = 0; i < synonyms.length; ++i){
			synonyms[i] = entries[synonymPositions.get(i)].getWord();
		}
		return synonyms;
	}
	
	private int findPosition(String word){
		int index = word.hashCode() % entries.length;
		if(index < 0) index += entries.length;
		int firstIndex = index;
		if(entries[index] == null) return -1;
		while(!word.equals(entries[index].getWord())){
			index = (1 + index) % entries.length;
			if(index < 0) index += entries.length;
			if(entries[index] == null || firstIndex == index)
				return -1;
		}
		return index;
	}
	
	private int addEntry(String word){
		int index = word.hashCode() % entries.length;
		if(index < 0) index += entries.length;
		int firstIndex = index;
		while(null != entries[index])   {
			index = (1 + index) % entries.length;
			if(firstIndex == index) {
				System.out.print("entries zu klein");
				System.exit(-1);
			}
		}
		entries[index] = new Entry(word);
		return index;
	}
}