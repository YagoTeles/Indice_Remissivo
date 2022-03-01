import java.util.ArrayList;

public class Entrada {
    public static class HashEntry {
        private String key;
        ArrayList<Integer> value = new ArrayList();
        HashEntry(String key, int value) {
            this.key = key;
            this.value.add(value);
        }

        public ArrayList<Integer> getValue() {
            return value;
        }

        public void addValue(int value) {
            this.value.add(value);
        }

        public String getKey() {
            return key;
        }
    }

    public static class DeletedEntry extends HashEntry {
        private static DeletedEntry entry = null;

        private DeletedEntry() {
            super("-1", -1);
        }

        public static DeletedEntry getUniqueDeletedEntry() {
            if (entry == null)
                entry = new DeletedEntry();
            return entry;
        }
    }
}
