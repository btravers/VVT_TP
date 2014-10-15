package system;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by btravers on 15/10/14.
 */
public class TestPhonyList {

    PhonyList<Integer> list3;
    PhonyList<Integer> listEmpty;
    PhonyList<Integer> listBig;


    @Before
    public void setUp() {
        list3 = list(1, 2, 3);
        listEmpty = list();
        listBig = thousandElementsList();
    }

    /*
	 * Helper method to create lists.
	 */
    private PhonyList<Integer> list(Integer... content) {
        PhonyList<Integer> list = new PhonyList<>();
        for (Integer i : content)
            list.add(i);
        return list;
    }

    /*
     * Helper method to create a big list [1,2,3,...,10000]
     */
    private PhonyList<Integer> thousandElementsList() {
        PhonyList<Integer> thousandElementsList = new PhonyList<>();
        for (int i = 1; i <= 10000; i++) {
            thousandElementsList.add(i);
        }
        return thousandElementsList;
    }

    @Test
    public void size_EmptyList() {
        PhonyList<Integer> list = list();

        assertEquals(0, list.size());
    }

    @Test
    public void size_thousandElementsList() {
        PhonyList<Integer> list = thousandElementsList();

        assertEquals(10000, list.size());
    }

    @Test
    public void size_many() {
        PhonyList<Integer> list = list(2, 3, 4);
        assertEquals(3, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_outOfRangeEmpty() {
        PhonyList<Integer> list = list();

        list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_outOfRange() {
        PhonyList<Integer> list = list(1,2,3);

        list.get(5);
    }

    @Test
    public void get_index() {
        PhonyList<Integer> list = list(2, 3, 4);
        assertTrue(3 == list.get(1));
    }

    @Test
    public void isEmpty_emptyList() {
        assertTrue(listEmpty.isEmpty());
    }

    @Test
    public void isEmpty_notEmptyList() {
        assertFalse(list3.isEmpty());
    }

    @Test
    public void contains_emptyList() {
        assertFalse(listEmpty.contains(1));
    }

    @Test
    public void contains_trueFirst() {
        assertTrue(list3.contains(1));
    }

    @Test
    public void contains_true() {
        assertTrue(list3.contains(2));
    }

    @Test
    public void contains_duplicate() {
        PhonyList<Integer> list = list(1,2,3,4,4,4);
        assertTrue(list.contains(4));
    }

    @Test
    public void contains_false() {
        assertFalse(list3.contains(4));
    }

    @Test
    public void addAll_Empty() {
        assertFalse(list3.addAll(2, list()));
        assertTrue(list3.size() == 3);
    }

    @Test
    public void addAll_Elements() {
        assertTrue(list3.addAll(1, list(4, 5)));
        assertTrue(list3.size() == 5);

        assertTrue(list3.get(1) == 4);
        assertTrue(list3.get(2) == 5);
        assertTrue(list3.get(3) == 2);
        assertTrue(list3.get(4) == 3);
        assertTrue(list3.get(0) == 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_outOfBounds() {
        list3.addAll(5, list(1));
    }

    @Test
    public void removeAll_all() {
        assertTrue(list3.removeAll(list(1,3,2)));
        assertTrue(list3.isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void removeAll_classException() {

        list3.removeAll(list(null));
    }

    @Test
    public void remove_item() {
        assertTrue(list3.remove(new Integer(3)));

        assertTrue(list3.size() == 2);
    }

    @Test
    public void remove_empty() {
        assertFalse(listEmpty.remove(new Integer(3)));

        assertTrue(listEmpty.size() == 0);
    }

    @Test
    public void remove_absentItem() {
        PhonyList<Integer> l = list(1,1);

        assertTrue(l.remove(new Integer(1)));

        assertTrue(l.size() == 0);
    }

    @Test
    public void remove_null() {
        PhonyList<Integer> l = list(null,null, 1);

        assertTrue(l.remove(null));

        assertTrue(l.size() == 1);
    }
}

