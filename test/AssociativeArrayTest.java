import associativeArray.AssociativeArray;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class AssociativeArrayTest {

    @Test(timeout=1000)
    public void testAdd() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);
        String actualValue = students.getValue(key);
        assertEquals(value, actualValue);

        String key2 = "id002";
        String nullableValue = null;
        students.add(key2, nullableValue);
        String actualValue2 = students.getValue(key2);
        assertEquals(nullableValue, actualValue2);
    }

    @Test(expected = NullPointerException.class)
    public void testAddWithKeyNull() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String nullableKey = null;
        String value = "Bob";
        students.add(nullableKey, value);
    }

    @Test (timeout=1000)
    public void testGetValue() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);
        String actualValue = students.getValue(key);
        assertEquals(value, actualValue);
    }

    @Test (timeout=1000)
    public void testGetKeysByValue() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);

        String key2 = "id002";
        String value2 = "Bob";
        students.add(key2, value2);

        String key3 = "id003";
        String value3 = "Bob";
        students.add(key3, value3);
        Set<String> keySet = students.getKeysByValue("Bob");
        assertEquals(keySet.size(), 2);
        assertTrue(keySet.contains(key2) && keySet.contains(key3));
    }

    @Test (timeout=1000)
    public void testRemove() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);
        assertTrue(students.containsKey(key));

        String key2 = "id002";
        String value2 = "Bob";
        students.add(key2, value2);
        assertTrue(students.containsKey(key2));

        String key3 = "id003";
        String value3 = "Bob";
        students.add(key3, value3);
        assertTrue(students.containsKey(key3));

        students.remove(key2);
        assertTrue(students.containsKey(key));
        assertFalse(students.containsKey(key2));
        assertTrue(students.containsKey(key));
        assertEquals(students.keySet().size(), 2);
    }

    @Test (timeout=1000)
    public void testUpdateValue() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Bob";
        students.add(key, value);

        String key2 = "id002";
        String value2 = "Bob";
        students.add(key2, value2);

        String newValue = "Kate";
        students.updateValue(key, newValue);
        assertEquals(students.getValue(key), newValue);
        assertEquals(students.getValue(key2), value2);
    }

    @Test (timeout=1000)
    public void testKeySet() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);

        String key2 = "id002";
        String value2 = "Bob";
        students.add(key2, value2);

        String key3 = "id003";
        String value3 = "Bob";
        students.add(key3, value3);

        Set<String> keySet = students.keySet();
        assertEquals(keySet.size(), 3);
        assertTrue(keySet.contains(key) && keySet.contains(key2) && keySet.contains(key3));
    }

    @Test (timeout=1000)
    public void testValueList() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);

        String key2 = "id002";
        String value2 = "Bob";
        students.add(key2, value2);

        String key3 = "id003";
        String value3 = "Bob";
        students.add(key3, value3);

        List<String> values = students.valueList();
        assertEquals(values.size(), 3);
        assertTrue(values.contains(value) && values.contains(value2) && values.contains(value3));
    }

    @Test (timeout=1000)
    public void testContainsKey() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);

        String key2 = "id002";
        String value2 = "Bob";
        students.add(key2, value2);
        assertTrue(students.containsKey(key));
        assertFalse(students.containsKey("id003"));
    }

    @Test (timeout=1000)
    public void testContainsValue() {
        AssociativeArray<String, String> students = new AssociativeArray<>();
        String key = "id001";
        String value = "Kate";
        students.add(key, value);

        String key2 = "id002";
        String value2 = "Bob";
        students.add(key2, value2);
        assertTrue(students.containsValue(value));
        assertFalse(students.containsValue("Triin"));
    }
}