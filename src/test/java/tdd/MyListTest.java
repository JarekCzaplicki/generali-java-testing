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
        testCollection.add(2);

        assertTrue(myList.containsAll(testCollection));
    }

    @Test
    void testAddAll() {
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");

        List<String> collectionToAdd = new ArrayList<>();
        collectionToAdd.add("three");
        collectionToAdd.add("four");

        assertTrue(list.addAll(collectionToAdd));
        assertTrue(list.contains("three"));
        assertTrue(list.contains("four"));
     }

     @Test
     void testGet(){
         MyList<String> list = new MyList<>();
         list.add("one"); // index 0
         list.add("two"); // index 1

         assertEquals("two", list.get(1));
         assertThrows(ArrayIndexOutOfBoundsException.class,() -> list.get(-1));
         assertThrows(ArrayIndexOutOfBoundsException.class,() -> list.get(2));
     }

    @Test
    void testAddAllAtIndex() {
        MyList<String> list = new MyList<>();
        list.add("one"); // index 0
        list.add("two"); // index 1 -> 3

        List<String> collectionToAdd = new ArrayList<>();
        collectionToAdd.add("three");
        collectionToAdd.add("four");

        assertTrue(list.addAll(1, collectionToAdd));

        assertEquals("one", list.get(0));
        assertEquals("three", list.get(1));
        assertEquals("four", list.get(2));
        assertEquals("two", list.get(3));
    }

    @Test
    void testRemoveAll(){
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        List<String> collectionToRemove = new ArrayList<>();
        collectionToRemove.add("two");
        collectionToRemove.add("four");
        assertTrue(list.removeAll(collectionToRemove));
        assertEquals(2, list.size());
        assertFalse(list.contains("two"));
        assertFalse(list.contains("four"));
    }

    @Test
    void testRetainAll(){
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        List<String> collectionToRetain = new ArrayList<>();
        collectionToRetain.add("two");
        collectionToRetain.add("four");
        assertTrue(list.retainAll(collectionToRetain));
        assertEquals(2, list.size());
        assertTrue(list.contains("two"));
        assertTrue(list.contains("four"));
        assertFalse(list.contains("one"));
        assertFalse(list.contains("three"));
    }

    @Test
    void clear() {
        MyList<String> list = new MyList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

}
