// Implement LFU caching.

// Answer:

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class qno29LFUCache {
    private int capacity;
    private Map<Integer, Integer> keyToValue;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    private int minFreq;

    public qno29LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }

        int freq = keyToFreq.get(key);
        freqToKeys.get(freq).remove(key);
        
        if (freq == minFreq && freqToKeys.get(freq).isEmpty()) {
            minFreq++;
        }
        
        keyToFreq.put(key, freq + 1);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value); // update value
            get(key); // increase frequency
            return;
        }

        if (keyToValue.size() >= capacity) {
            int evict = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(evict);
            keyToValue.remove(evict);
            keyToFreq.remove(evict);
        }

        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }

    public static void main(String[] args) {
        qno29LFUCache cache = new qno29LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);                        // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
