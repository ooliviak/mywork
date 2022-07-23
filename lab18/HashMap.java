
import java.util.Iterator;

public class HashMap<K, V> implements Map61BL<K, V> {

    private Entry[] arr;
    private int size = 0;
    private int initialCapacity = 16;
    private double maxLoadFactor = 0.75;

    public HashMap() {
        arr = new Entry[16];
    }

    public HashMap(int initialCapacity) {
        arr = new Entry[initialCapacity];
    }

    public HashMap(int initialCapacity, double loadFactor) {
        arr = new Entry[initialCapacity];
    }

    public int capacity() {
        return arr.length;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
        this.size = 0;

    }

    @Override
    public boolean containsKey(K key) {
        int hashNum = hash((String) key);
        if (get(key) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public V get(K key) {
        int hashNum = hash((String) key);
        Entry list = arr[hashNum];
        if (list == null) {
            return null;
        } else {
            return (V) getHelper(key, list);
        }
    }

    public V getHelper(K key, Entry list) {
        if (list.key.equals(key)) {
            return (V) list.value;
        } else {
            return (V) getHelper(key, list.next);
        }
    }

    @Override
    public void put(K key, V value) {
        int hashNum = hash((String) key);
        Entry list = arr[hashNum];

        if (list == null) {
            list = new Entry(key, value);
            arr[hashNum] = list;
            size ++;
        } else if (list.key == key) {
            list.value = value;
        } else {
            putHelper(key, value, list);
        }
        if ((size / arr.length) > maxLoadFactor) {
            resize();
        }
    }

    public void putHelper(K key, V value, Entry list) {
        if (list.key == key) {
            list.value = value;
        } else if (list.next == null) {
            list.next = new Entry(key, value);
            size ++;
        } else {
            putHelper(key, value, list.next);
        }
    }

    private void resize() {
        HashMap<K, V> resized = new HashMap<>(2 * arr.length);
        for (int i = 0; i < arr.length; i++) {
            resized.put((K) arr[i].key, get((K) arr[i].key));
        }
        initialCapacity = resized.size;
        this.arr = resized.arr;
    }

    @Override
    public V remove(K key) {
        int hashNum = hash((String) key);
        Entry list = arr[hashNum];
        if (list == null) {
            return null;
        } else {
            return removeHelper(key, list);
        }
    }

    public V removeHelper(K key,  Entry list) {
        int hashNum = hash((String) key);
        if (list.key.equals(key)) {
            size --;
            V val = (V) list.value;
            list = null;
            arr[hashNum] = list;
            return val;
        } else {
            return (V) removeHelper(key, list.next);
        }
    }

    @Override
    public boolean remove(K key, V value) {
        int hashNum = hash((String) key);
        Entry list = arr[hashNum];
        if (list == null && list.value == null) {
            return true;
        } else {
            removeHelper2(key, value, list);
        }
        return false;
    }

    public boolean removeHelper2(K key, V value, Entry list) {
        int hashNum = hash((String) key);
        if (list.key.equals(key)) {
            size --;
            list = null;
            arr[hashNum] = list;
            return true;
        } else {
            removeHelper(key, list.next);
        }
        return false;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public int hash(String key) {
        if (key == null) {
            return 0;
        } else {
            return Math.floorMod(key.hashCode(), arr.length);
        }
    }
    private static class Entry<K, V> {

        private K key;
        private V value;
        private Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        /* Returns true if this key matches with the OTHER's key. */
        public boolean keyEquals(Entry other) {
            return key.equals(other.key);
        }

        /* Returns true if both the KEY and the VALUE match. */
        @Override
        public boolean equals(Object other) {
            return (other instanceof Entry
                    && key.equals(((Entry) other).key)
                    && value.equals(((Entry) other).value));
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
}