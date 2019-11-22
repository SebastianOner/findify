import java.util.ArrayList;

public class Synonym{
	private static class Entry {
		String    word;
		ArrayList<Integer> references;
		
		private Entry(String word){
			this.word       = word;
		}
		
		private void addReference(int reference) {
			references.add(reference);
		}
		
		private String getWord() {
			return word;
		}
		
		private ArrayList<Integer> getReferences() {
			return references;
		}
	}
	private static Entry[] entries = new Entry[100];
	private static String[][] entryInput = {{},{}};
	
	public Synonym() {
		int length = entryInput.length;
		int[] entryPositions;
		for(String[] synonyms : entryInput) {
			entryPositions = new int[synonyms.length];
			for(int i = 0; i < synonyms.length; ++i) {
				entryPositions[i] = findPosition(synonyms[i]);
				if(-1 == entryPositions[i]) {
					entryPositions[i] = addEntry(synonyms[i]);
				}
			}
			for(int entryPosition : entryPositions) {
				for(int reference : entryPositions) {
					entries[entryPosition].addReference(reference);
				}
			}
		}
	}
	
	public static String[] getSynonyms(String string) {
		ArrayList<Integer> synonymPositions =
				entries[findPosition(string)].getReferences();
		String[] synonyms = new String[synonymPositions.size()];
		for(int i = 0; i < synonyms.length; ++i) {
			synonyms[i] = entries[synonymPositions.get(i)].getWord() ;
		}
		return synonyms;
	}
	
	private static int findPosition(String word) {
		int length = entries.length, index = word.hashCode() % length,
				firstIndex = index;
		while(entries[index] != null && word != entries[index].getWord()) {
			index = (1 + index) % length;
			if(firstIndex == index) return -1;
		}
		return index;
	}
	
	private static int addEntry(String word) {
		int index = word.hashCode() % entries.length;
		while(null != entries[index]) ++index;
		entries[index] = new Entry(word);
		return index;
	}
}