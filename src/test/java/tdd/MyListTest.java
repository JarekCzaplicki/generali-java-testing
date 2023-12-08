package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {

    private MyList<Integer> myList;

    @BeforeEach
    void setUp() {
        myList = new MyList<>();
    }


    @Test
    void addElementToList() {
        myList.add(1);
        assertEquals(myList.size(), 1);
    }

    @Test
    void addElementsToList() {
        myList.add(1);
        myList.add(1);
        myList.add(1);
        assertEquals(myList.size(), 3);
    }

    @Test
    void isListEmpty() {
        assertTrue(myList.isEmpty());
    }

    @Test
    void isListNotEmpty() {
        myList.add(1);
        assertFalse(myList.isEmpty());
    }

    @Test
    void doesListContainObject() {
        myList.add(1);
        assertTrue(myList.contains(1));
    }

    @Test
    void testEmptyListIterator() {
        Iterator<Integer> iterator = myList.iterator();

        assertNotNull(iterator);
    }

    @Test
    void testHasNextMethodFromListIterator() {
        Iterator<Integer> iterator = myList.iterator();

        assertFalse(iterator.hasNext()); // sprawdzamy czy dla pustej listy mamy zwracane false
    }

    @Test
    void testNextMethodFromListIterator() {
        Iterator<Integer> iterator = myList.iterator();

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testHasNextMethodFromListIteratorWithFullLIst() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        Iterator<Integer> iterator = myList.iterator();

        assertTrue(iterator.hasNext());
    }

    @Test
    void testNextMethodFromListIteratorWithFullLIst() {
        myList.add(1);
        myList.add(2);
        myList.add(3);
        Iterator<Integer> iterator = myList.iterator();

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());

        assertFalse(iterator.hasNext());

        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testIfToArrayReturnsNotNull(){
        MyList<String> list = new MyList<>();

        Object[] array = list.toArray();

        assertNotNull(array);
    }

    @Test
    void testIfToArrayReturnsCorrectLength(){
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Object[] array = list.toArray();

        assertEquals(3,array.length);
    }

    @Test
    void testIfReturnedArrayHasElementsFromList(){
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Object[] array = list.toArray();

        assertArrayEquals(new Object[]{"one", "two", "three"}, array);
    }

    @Test
    void testToArrayWithArrayArguments() {
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        String[] existingArray = new String[3];
        String[] resultArray = list.toArray(existingArray);

        assertSame(existingArray, resultArray);
    }

    @Test
    void testToArrayWithArrayArgumentsIfReturnedArrayHasSameElements(){ // Do poprawienia jako zadanie
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        String[] existingArray = new String[3]; // null, null, null
        String[] resultArray = list.toArray(existingArray);

        assertArrayEquals(new String[]{"one", "two", "three"}, resultArray);
    }

    @Test
    void testRemoveElements(){
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        assertTrue(list.remove("two"));
        assertEquals(2, list.size());
        assertFalse(list.contains("two"));
    }

    @Test
    void testContainsAll(){
        myList.add(1);
        myList.add(2);
        myList.add(3);

        List<Integer> testCollection = new ArrayList<>();
        testCollection.add(2);
        testCollection.add(3);

        assertTrue(myList.contains(testCollection));
    }
}
