public class qno13MyHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private Entry<K, V>[] table;
    private int size;
    private int capacity;

    public qno13MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public qno13MyHashMap(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new Entry[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        if (key == null)
            return;

        if (size >= LOAD_FACTOR_THRESHOLD * capacity) {
            resize();
        }

        int index = hash(key);
        int initialIndex = index;
        int i = 1;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (initialIndex + i * i) % capacity; // Quadratic probing
            i++;
        }

        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            table[index].value = value; // Update value if key already exists
        }
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    private void resize() {
        // Resize the hash table and rehash all entries
        // Code for resizing omitted for brevity
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
