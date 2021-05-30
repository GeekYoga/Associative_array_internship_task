package associativeArray;

import java.util.Objects;

public class Pair<K, V>{

    private K key;
    private V value;

    /** Pair constructor
     * @param k key of pair
     * @param v value of pair
    */
    Pair(K k, V v) {
        setKey(k);
        setValue(v);
    }

    /** Key of the pair.
    * @return key
    */
    public K getKey() {
        return this.key;
    }

    /** Set key of the pair.
    */
    public void setKey(K k) {
        this.key = k;
    }

    /** Value of the pair.
    * @return value
    */
    public V getValue() {
        return this.value;
    }

    /** Set value of the pair.
    */
    public void setValue(V v) {
        this.value = v;
    }

    /** Conversion of the pair to the string.
    * @return a key and value of node as string
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.key);
        sb.append(": ");
        sb.append(this.value);
        return sb.toString();
    }

    /** Integer hashCode has to be the same for equal objects.
    * @return hashcode
    */
   @Override
   public int hashCode() {
      return Objects.hash(this.getKey(), this.getValue());
   }

    /**Equality test of pairs.
     *
     * @param o second pair
     * @return logical value of the expression <code>this.equals(o)</code>
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            throw new ClassCastException("Object " + o + " is NOT Pair");
        }

        Pair p = (Pair) o;

        return this.getKey().equals(p.getKey()) && this.getValue().equals(p.getValue());
    }

}
