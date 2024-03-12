// What is hashing? Explain concept of hash table and hash function with example and implement linear 
// probing collision resolution function.(code for insertion only)


// Answer::

// Hashing is a technique used in computer science to map data of arbitrary size to fixed-size values, 
// typically for faster data retrieval. 
// A hash table is a data structure that implements an associative array abstract data type, a structure 
// that can map keys to values. It uses a hash function to compute an index into an array of buckets or slots, 
// from which the desired value can be found.

public class qno15HashTable {
    private int[] table;
    private int size;

    public qno15HashTable(int size) {
        this.size = size;
        table = new int[size];
    }

    public void insert(int key, int value) {
        int hash = hashFunction(key);

        if (table[hash] == 0) {
            table[hash] = value; // Insert value if slot is empty
        } else {
            // Linear probing for collision resolution
            int probe = (hash + 1) % size;
            while (probe != hash && table[probe] != 0) {
                probe = (probe + 1) % size;
            }
            if (probe == hash) {
                System.out.println("Hash table is full. Cannot insert.");
            } else {
                table[probe] = value; // Insert value in the next available slot
            }
        }
    }

    private int hashFunction(int key) {
        return key % size; // Simple hash function for demonstration
    }

    public static void main(String[] args) {
        qno15HashTable ht = new qno15HashTable(10);
        ht.insert(5, 10);
        ht.insert(15, 20);
        ht.insert(25, 30);
        ht.insert(35, 40);
        ht.insert(45, 50);
        ht.insert(5, 60); // Collision occurs, will be resolved using linear probing
    }
}
