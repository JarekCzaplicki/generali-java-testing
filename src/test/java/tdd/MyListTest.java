package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {

    private MyList<Integer> myList;
    @BeforeEach
    void setUp(){
        myList = new MyList<>();
    }


    @Test
    void addElementToList(){
        myList.add(1);
        assertEquals(myList.size(), 1);
    }

    @Test
    void addElementsToList(){
        myList.add(1);
        myList.add(1);
        myList.add(1);
        assertEquals(myList.size(), 3);
    }

    @Test
    void isListEmpty(){
        assertTrue(myList.isEmpty());
    }

    @Test
    void isListNotEmpty(){
        myList.add(1);
        assertFalse(myList.isEmpty());
    }

    @Test
    void doesListContainObject(){
        myList.add(1);
        assertTrue(myList.contains(1));
    }


}
