package associativeArray;

import java.util.*;

public class AssociativeArray<K, V>{

    /**
     * Main method for testing purposes.
     *
    * @param args command line parameters
    */
    public static void main(String[] args) {
        AssociativeArray<String, String> test = new  AssociativeArray<>();
        System.out.println(test.containsKey("1"));
    }

    private ArrayList<Pair<K, V>> pairs;

    /**
     * Associative array constructor
    */
    public AssociativeArray() {
      this.pairs = new ArrayList<>();
   }

    /**
     * Associates the specified value with the specified key in this associative array.
     * If the associative array previously contained a mapping for the key, the old value is replaced.
     *
     * @param k - key with which the specified value v is to be associated.
     * @param v - value to be associated with the specified key k.
     */
    public void add(K k, V v) {
        if (k == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        if (this.containsKey(k)) {
            this.updateValue(k, v);
        } else {
             Pair<K, V> newPair = new Pair<>(k, v);
             pairs.add(newPair);
        }
    }

    /**
     * Returns a value associated with a particular key in this associative array.
     *
     * @param k - the key of pair whose value in this associative array is to be found.
     * @return value associated with the key or null if key was not found.
     * */
    public V getValue(K k) {
        if (k == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        if (!this.containsKey(k)) {
            throw new RuntimeException("Key:" + k + " is not found.");
        }

        Iterator<Pair<K,V>> iterator = this.pairs.listIterator();
        while (iterator.hasNext()) {
            Pair<K,V> pair = iterator.next();

            if (pair.getKey().equals(k)) {
                return pair.getValue();
            }
        }

        // In theory this return is not reachable.
        return null;
    }

    /**
     * Returns a set of keys associated with a particular value in this associative array.
     *
     * @param v - the value of one or more pair whose key in this associative array is to be found.
     * @return key set associated with given value.
     * */
    public Set<K> getKeysByValue(V v) {
        Set<K> keys = new HashSet<>();
        if (this.containsValue(v)) {
            Iterator<Pair<K,V>> iterator = this.pairs.listIterator();

            while (iterator.hasNext()) {
                Pair<K,V> pair = iterator.next();
                if (pair.getValue().equals(v)) {
                    keys.add(pair.getKey());
                }
            }
        }

        return keys;
    }

    /**
     * Returns a pair with particular key in this associative array.
     *
     * @param k - the key of pair who is to be found.
     * @return pair with particular key.
     */
    private Pair<K, V> getPair(K k) {
        if (k == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        if (this.containsKey(k)) {
            Iterator<Pair<K,V>> iterator = this.pairs.listIterator();

            while (iterator.hasNext()) {
                Pair<K,V> pair = iterator.next();
                if (pair.getKey().equals(k)) {
                    return pair;
                }
            }
        }

        return null;
    }

    /**
     * Removes the pair from this associative array.
     * Unmap a given key from its value.
     *
     * @param k – key whose mapping is to be removed from the associative array.
     */
    public void remove(K k) {
        if (k == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        if (this.containsKey(k)) {
            pairs.remove(this.getPair(k));
        }
    }

    /**
     * Replaces the value in one of the pairs that are in this associative array.
     *  Mapping an existing key to a new value.
     *
     * @param k - the key of pair whose value in this associative array is to be replaced.
     * @param v - new value to be associated with the specified key
     */
    public void updateValue(K k, V v) {
        if (k == null) {
            throw new NullPointerException("Key cannot be null.");
        }

        this.getPair(k).setValue(v);
    }

    /**
     * Returns a set of the keys contained in this associative array.
     *
     * @return a set of the keys
     */
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        Iterator<Pair<K,V>> iterator = this.pairs.listIterator();

        while (iterator.hasNext()) {
            Pair<K, V> pair = iterator.next();
            keys.add(pair.getKey());
        }

        return keys;
    }

    /**
     * Returns a list of the values contained in this associative array.
     *
     * @return a list of the values
     */
    public List<V> valueList() {
        List<V> values = new ArrayList<>();
        Iterator<Pair<K,V>> iterator = this.pairs.listIterator();

        while (iterator.hasNext()) {
            Pair<K, V> pair = iterator.next();
            values.add(pair.getValue());
        }

        return values;
    }

    /**
     * Returns true if this associative array contains the specified key.
     *
     * @param k -the key whose presence in this associative array is to be tested.
     * @return true if this associative array contains the specified key, otherwise false.
     */
    public boolean containsKey(K k) {
        Set<K> keys = this.keySet();

        return keys.contains(k);
    }

    /**
     * Returns true if this associative array contains one or more keys to the specified value.
     *
     * @param v -the value whose presence in this associative array is to be tested.
     * @return true if this associative array contains one or more keys to the specified value, otherwise false.
     */
    public boolean containsValue(V v) {
        List<V> values = this.valueList();

        return values.contains(v);
    }

}
