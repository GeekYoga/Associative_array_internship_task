package associativeArray;

public class Pair<T1, T2>{

    private T1 key;
    private T2 value;

    /** Pair constructor
     * @param k key of pair
     * @param v value of pair
    */
    Pair(T1 k, T2 v) {
        setKey(k);
        setValue(v);
    }

    /** Key of the pair.
    * @return key
    */
    public T1 getKey() {
        return this.key;
    }

    /** Set key of the pair.
    */
    public void setKey(T1 k) {
        this.key = k;
    }

    /** Value of the pair.
    * @return value
    */
    public T2 getValue() {
        return this.value;
    }

    /** Set value of the pair.
    */
    public void setValue(T2 v) {
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

    //TODO hashCode()
    //TODO equalsTo()

}
