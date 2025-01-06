

import org.junit.jupiter.api.Test;
import ru.vsu.cs.logic.ArrayListList;
import ru.vsu.cs.logic.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListListTest {

    /* -----------------------------------------testAdd---------------------------------------- */
    @Test
    public void testAdd() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.add(0, 1);
        assertEquals(1, list.get(0));

        list.add(1, 2);
        assertEquals(2, list.get(1));

        try {
            list.add(-1, 3);
            fail("Ожидалась ошибка IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            list.add(3, 4);
            fail("Ожидалась ошибка IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /* -----------------------------------------testAddAll---------------------------------------- */
    @Test
    public void testAddAll() {
        ArrayListList<Integer> list1 = new ArrayListList<>();
        list1.add(0, 1);
        list1.add(1, 2);

        ArrayListList<Integer> list2 = new ArrayListList<>();
        list2.add(0, 3);
        list2.add(1, 4);

        list1.addAll(1, list2);
        assertEquals(3, list1.get(1));
        assertEquals(4, list1.get(2));

        try {
            list1.addAll(-1, list2);
            fail("Ожидалась ошибка IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /* -----------------------------------------testAddFirst---------------------------------------- */
    @Test
    public void testAddFirst() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.addFirst(1);
        assertEquals(1, list.get(0));

        list.addFirst(2);
        assertEquals(2, list.get(0));
    }

    /* -----------------------------------------testAddLast---------------------------------------- */
    @Test
    public void testAddLast() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.addLast(1);
        assertEquals(1, list.get(0));

        list.addLast(2);
        assertEquals(2, list.get(1));
    }

    /* -----------------------------------------testClear---------------------------------------- */
    @Test
    public void testClear() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.add(0, 1);
        list.add(1, 2);
        assertEquals(2, list.size());

        list.clear();
        assertTrue(list.isEmpty());
    }

    /* -----------------------------------------testContains---------------------------------------- */
    @Test
    public void testContains() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.add(0, 1);
        list.add(1, 2);

        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    /* -----------------------------------------testContainsAll---------------------------------------- */
    @Test
    public void testContainsAll() {
        ArrayListList<Integer> list1 = new ArrayListList<>();
        list1.add(0, 1);
        list1.add(1, 2);
        list1.add(2, 3);

        ArrayListList<Integer> list2 = new ArrayListList<>();
        list2.add(0, 1);
        list2.add(1, 2);

        ArrayListList<Integer> list3 = new ArrayListList<>();
        list3.add(0, 4);
        list3.add(1, 5);

        assertTrue(list1.containsAll(list2));
        assertFalse(list1.containsAll(list3));
    }

    /* -----------------------------------------testEquals---------------------------------------- */
    @Test
    public void testEquals() {
        ArrayListList<Integer> list1 = new ArrayListList<>();
        list1.add(0, 1);
        list1.add(1, 2);

        ArrayListList<Integer> list2 = new ArrayListList<>();
        list2.add(0, 1);
        list2.add(1, 2);

        ArrayListList<Integer> list3 = new ArrayListList<>();
        list3.add(0, 2);
        list3.add(1, 1);

        assertTrue(list1.equals(list2));
        assertFalse(list1.equals(list3));
    }

    /* -----------------------------------------testGet---------------------------------------- */
    @Test
    public void testGet() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.add(0, 1);
        list.add(1, 2);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));

        try {
            list.get(2);
            fail("Ожидалась ошибка IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /* -----------------------------------------testGetFirstAndGetLast---------------------------------------- */
    @Test
    public void testGetFirstAndGetLast() {
        ArrayListList<Integer> list = new ArrayListList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(Integer.valueOf(1), list.getFirst());

        assertEquals(Integer.valueOf(3), list.getLast());
    }

    /* -----------------------------------------testRemove---------------------------------------- */
    @Test
    public void testRemove() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(2, list.remove(1));
        assertEquals(2, list.size());

        try {
            list.remove(2);
            fail("Ожидалась ошибка IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    /* -----------------------------------------testReversed---------------------------------------- */
    @Test
    public void testReversed() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        List<Integer> reversedList = list.reversed();
        assertEquals(3, reversedList.get(0));
        assertEquals(2, reversedList.get(1));
        assertEquals(1, reversedList.get(2));
    }

    /* -----------------------------------------testHashCode---------------------------------------- */
    @Test
    public void testHashCode() {
        ArrayListList<Integer> list1 = new ArrayListList<>();
        list1.add(0, 1);
        list1.add(1, 2);
        ArrayListList<Integer> list2 = new ArrayListList<>();
        list2.add(0, 1);
        list2.add(1, 2);
        ArrayListList<Integer> list3 = new ArrayListList<>();
        list3.add(0, 3);

        assertEquals(list1.hashCode(), list2.hashCode());
        assertNotEquals(list1.hashCode(), list3.hashCode());
    }

    /* -----------------------------------------testIndexOf---------------------------------------- */
    @Test
    public void testIndexOf() {
        ArrayListList<Integer> list = new ArrayListList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));
    }

    /* -----------------------------------------testIsEmpty---------------------------------------- */
    @Test
    public void testIsEmpty() {
        ArrayListList<Integer> list = new ArrayListList<>();
        assertTrue(list.isEmpty());

        list.add(0, 1);
        assertFalse(list.isEmpty());
    }

    /* -----------------------------------------testLastIndexOf---------------------------------------- */
    @Test
    public void testLastIndexOf() {
        ArrayListList<Integer> list = new ArrayListList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 2);

        assertEquals(2, list.lastIndexOf(2));
        assertEquals(-1, list.lastIndexOf(3));
    }

    /* -----------------------------------------testRemoveFirst---------------------------------------- */
    @Test
    public void testRemoveFirst() {
        ArrayListList<Integer> list = new ArrayListList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(Integer.valueOf(1), list.removeFirst());
        assertEquals(2, list.size());
    }

    /* -----------------------------------------testRemoveLast---------------------------------------- */
    @Test
    public void testRemoveLast() {
        ArrayListList<Integer> list = new ArrayListList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(Integer.valueOf(3), list.removeLast());
        assertEquals(2, list.size());
    }

    /* -----------------------------------------testSet---------------------------------------- */
    @Test
    public void testSet() {
        ArrayListList<Integer> list = new ArrayListList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        list.set(1, 5);
        assertEquals(Integer.valueOf(5), list.get(1));
    }

    /* -----------------------------------------testSize---------------------------------------- */
    @Test
    public void testSize() {
        ArrayListList<Integer> list = new ArrayListList<>();

        assertEquals(0, list.size());

        list.add(0, 1);
        list.add(1, 2);
        assertEquals(2, list.size());
    }

    /* -----------------------------------------testToArray---------------------------------------- */
    @Test
    public void testToArray() {
        ArrayListList<Integer> list = new ArrayListList<>();

        list.add(0, 1);
        list.add(1, 2);

        Object[] array = list.toArray();
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
    }
}
