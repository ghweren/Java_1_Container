import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyIntVectorTest {

    MyIntVector testVector;

    @BeforeEach
    void prepareData()
    {
        testVector = new MyIntVector();
    }

    @org.junit.jupiter.api.Test
    void push_back_to_empty() {
        testVector.push_back(1);
        assertArrayEquals(new int[]{1},testVector.toArray());
        assertEquals(1,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @Test
    void often_push_back()
    {
        testVector.push_back(1);
        testVector.push_back(2);
        testVector.push_back(3);
        assertArrayEquals(new int[]{1,2,3},testVector.toArray());
        assertEquals(3,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @Test
    void push_back_then_higher_capacity()
    {
        for(int i = 0;i<9;i++)
            testVector.push_back(i);
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8},testVector.toArray());
        assertEquals(9,testVector.getSize());
        assertEquals(20,testVector.getCapacity());
    }


    @org.junit.jupiter.api.Test
    void push_front_then_empty() {
        testVector.push_front(1);
        assertArrayEquals(new int[]{1},testVector.toArray());
        assertEquals(1,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @Test
    void often_push_front()
    {
        testVector.push_front(1);
        testVector.push_front(2);
        testVector.push_front(3);
        assertArrayEquals(new int[]{3,2,1},testVector.toArray());
        assertEquals(3,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @Test
    void push_front_then_higher_capacity()
    {
        for(int i = 0;i<9;i++)
            testVector.push_front(i);
        assertArrayEquals(new int[]{8,7,6,5,4,3,2,1,0},testVector.toArray());
        assertEquals(9,testVector.getSize());
        assertEquals(20,testVector.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void pop_back() {
    }

    @org.junit.jupiter.api.Test
    void pop_front() {
    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void replace() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }

    @org.junit.jupiter.api.Test
    void getSize() {
    }

    @org.junit.jupiter.api.Test
    void getCapacity() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void resize() {
    }
}