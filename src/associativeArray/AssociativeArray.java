package associativeArray;

import java.util.*;

public class AssociativeArray<K, V>{

    /** Main method for testing purposes.
    * @param args command line parameters
    */
    public static void main(String[] args) {
        AssociativeArray<String, String> test = new  AssociativeArray<>();
        System.out.println(test.containsKey("1"));

        System.out.println("Hello");
    }

    private ArrayList<Pair<K, V>> pairs = new ArrayList<>();

    /** Associates the specified value with the specified key in this associative array.
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

    // TODO fix
    public Pair<K, V> get(K k) {
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

    // TODO remove a pair from the collection;
    //Removes the mapping for the specified key from this map if present.
    //Params: key – key whose mapping is to be removed from the map
    //Returns: the previous value associated with key, or null if there was no mapping for key.
    // (A null return can also indicate that the map previously associated null with key.)

    // TODO modify an existing pair;
    public void updateValue(K k, V v) {

    }

    // TODO lookup a value associated with a particular key.


    /** Returns a set of the keys contained in this associative array.
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

    /** Returns a list of the values contained in this associative array.
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

    /** Returns true if this associative array contains the specified key.
     *
     * @param k -the key whose presence in this associative array is to be tested.
     * @return true if this associative array contains the specified key, otherwise false.
     */
    public boolean containsKey(K k) {
        Set<K> keys = this.keySet();

        return keys.contains(k);
    }

    /** Returns true if this associative array contains one or more keys to the specified value.
     *
     * @param v -the value whose presence in this associative array is to be tested.
     * @return true if this associative array contains one or more keys to the specified value, otherwise false.
     */
    public boolean containsValue(V v) {
        List<V> values = this.valueList();

        return values.contains(v);
    }

}
