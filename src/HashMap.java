import java.util.ArrayList;

public class HashMap {
    private final int DEFAULT_TABLE_SIZE = 128;
    private float threshold = 0.75f;
    private int maxSize = 96;
    private int size = 0;
    Entrada.HashEntry[] table;

    HashMap() {
        table = new Entrada.HashEntry[DEFAULT_TABLE_SIZE];

        for (int i = 0; i < DEFAULT_TABLE_SIZE; i++)

            table[i] = null;
    }

    void setThreshold(float threshold) {

        this.threshold = threshold;

        maxSize = (int) (table.length * threshold);
    }

    public ArrayList<Integer> get(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++)
            hash = (31 * hash + key.charAt(i)) % table.length;
        int initialHash = -1;
        while (hash != initialHash

                && (table[hash] == Entrada.DeletedEntry.getUniqueDeletedEntry()

                || table[hash] != null

                && table[hash].getKey().compareToIgnoreCase(key) != 0 )) {

            if (initialHash == -1)

                initialHash = hash;

            hash = (hash + 1) % table.length;

        }

        if (table[hash] == null || hash == initialHash)

            return new ArrayList<>();

        else

            return table[hash].getValue();

    }

    public void put(String key, int value) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++)
            hash = (31 * hash + key.charAt(i)) % table.length;

        int initialHash = -1;
        int indexOfDeletedEntry = -1;
        while (hash != initialHash
                && (table[hash] == Entrada.DeletedEntry.getUniqueDeletedEntry()
                || table[hash] != null
                && table[hash].getKey().compareToIgnoreCase(key) != 0 )) {
            if (initialHash == -1)
                initialHash = hash;
            if (table[hash] == Entrada.DeletedEntry.getUniqueDeletedEntry())
                indexOfDeletedEntry = hash;
            hash = (hash + 1) % table.length;
        }
        if ((table[hash] == null || hash == initialHash)
                && indexOfDeletedEntry != -1) {
            table[indexOfDeletedEntry] = new Entrada.HashEntry(key, value);
            size++;
        } else if (initialHash != hash)
            if (table[hash] != Entrada.DeletedEntry.getUniqueDeletedEntry()
                    && table[hash] != null && table[hash].getKey().compareToIgnoreCase(key) == 0 )
                table[hash].addValue(value);
            else {
                table[hash] = new Entrada.HashEntry(key, value);
                size++;
            }
    }

}
