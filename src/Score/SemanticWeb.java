package Score;

import java.util.ArrayList;

final public class SemanticWeb {
    /*Hashtabelle. Größe sollte prim sein.
     */
    private Entry[] entries = new Entry[97];

    /**
     * @param input Jedes Array entspricht einer Gruppe von Synonymen.
     *              Der Input wird in den Einträgen gespeichert.
     */
    public SemanticWeb(String[][] input) {
        int[] synonymPositions;
        for (String[] synonyms : input) {
            /**
             Synonym-Positionen werden gespeichert, um später Referenzen auf
             jene hinzufügen zu können.
             */
            synonymPositions = new int[synonyms.length];
            for (int i = 0; i < synonyms.length; ++i) {
                synonymPositions[i] = findPosition(synonyms[i]);
                /**
                 Wenn Eintrag nicht gefundn wurde, wird ein neuer erstellt.
                 */
                if (-1 == synonymPositions[i]) {
                    synonymPositions[i] = addEntry(synonyms[i]);
                }
            }
            /**
             Referenzen werden hinzugefügt. Symmetrisch.
             */
            for (int synonymPosition : synonymPositions) {
                for (int reference : synonymPositions) {
                    /**
                     Keine Referenz auf sich selbst.
                     */
                    if (synonymPosition != reference)
                        entries[synonymPosition].addReference(reference);
                }
            }
        }
    }

    public double getSimilarity(String a, String b) {
        if (a == null || b == null)
            return 0;
        if(a.equals(b))
            return 1;
        MaxHeap<Entry> unvisitedEntries = new MaxHeap<>();
        for (Entry entry : entries) {
            if (entry != null)
                entry.setNode(unvisitedEntries.enqueue(entry, a.equals(entry.getWord()) ? 1 : 0));
        }
        MaxHeap.Node node;
        while (unvisitedEntries.size() > 0) {
            node = unvisitedEntries.dequeueMax();
            Entry entry = (Entry) node.getObject();
            if (b.equals(entry.getWord())) {
                return entry.getSimilarity();
            }
            entry.getReferences().forEach(reference -> {
                int position = reference.getPosition();
                double alternative = entry.getSimilarity() * reference.getWeight();
                if (entries[position].getSimilarity() <
                        alternative) {
                    unvisitedEntries.IncreaseKey(
                            entries[position].getNode(),
                            alternative);
                    entry.setSimilarity(alternative);
                }
            });
        }
        return 0;
    }

    private int findPosition(String word) {
        int index = map(word.hashCode() % entries.length);
        /**
         Index wird auf Bereich zwischen 0 und entries.length gemappt.
         */
        int firstIndex = index;
        //Wenn null, ist Eintrag nicht enthalten.
        if (entries[index] == null)
            return -1;
        /**
         Wegen Kollisionen wird gesucht, bis Eintrag gefunden wird.
         */
        while (!word.equals(entries[index].getWord())) {
            index = map((1 + index) % entries.length);
            if (entries[index] == null || firstIndex == index)
                return -1;
        }
        return index;
    }

    private int addEntry(String word) {
        int index = map(word.hashCode() % entries.length);
        int firstIndex = index;
        while (null != entries[index]) {
            index = (1 + index) % entries.length;
            if (firstIndex == index) {
                System.out.print("entries zu klein");
                System.exit(-1);
            }
        }
        entries[index] = new Entry(word);
        return index;
    }

    class Entry {
        String word;
        ArrayList<Reference> references = new ArrayList<>();
        double similarity;
        MaxHeap.Node node;

        private Entry(String word) {
            this.word = word;
        }

        private void addReference(int position) {
            for (Reference reference : references) {
                if (position == reference.getPosition())
                    return;
            }
            references.add(new Reference(position));
        }

        private void setNode(MaxHeap.Node node) {
            this.node = node;
            similarity = node.getPriority();
        }

        private String getWord() {
            return word;
        }

        private ArrayList<Reference> getReferences() {
            return references;
        }

        private double getSimilarity() {
            return similarity;
        }

        private MaxHeap.Node getNode() {
            return node;
        }

        public void setSimilarity(double similarity) {
            this.similarity = similarity;
        }

        class Reference {
            private int position;
            private double weight;

            private Reference(int position) {
                this.position = position;
                weight = 0.5;
            }

            private int getPosition() {
                return position;
            }

            private double getWeight() {
                return weight;
            }
        }
    }

    private int map(int i) {
        return i >= 0 ? i : i + entries.length;
    }
}