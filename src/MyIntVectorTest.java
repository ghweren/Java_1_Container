import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void pop_back_then_empty() {
        try {
            testVector.pop_back();
        }
        catch (Exception e)
        {
            assertEquals("Vector is empty",e.getMessage());
        }
    }

    @Test
    void often_pop_back()
    {
        testVector.push_front(1);
        testVector.push_front(2);
        testVector.push_front(3);
        int elem =testVector.pop_back();
        assertEquals(1,elem);
        assertArrayEquals(new int[]{3,2},testVector.toArray());
        assertEquals(2,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void pop_front_then_empty() {
        try {
            testVector.pop_front();
        }
        catch (Exception e)
        {
            assertEquals("Vector is empty",e.getMessage());
        }
    }

    @Test
    void often_pop_front()
    {
        testVector.push_front(1);
        testVector.push_front(2);
        testVector.push_front(3);
        int elem =testVector.pop_front();
        assertEquals(3,elem);
        assertArrayEquals(new int[]{2,1},testVector.toArray());
        assertEquals(2,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void add_if_out_of_bounds() throws RuntimeException
    {
        try{
            testVector.add(1,0);
            throw new RuntimeException("Invalid operation");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertEquals("Index is out of bounds",e.getMessage());
        }
    }

    @Test
    void often_add()
    {
        testVector.push_back(1);
        testVector.push_back(2);
        testVector.push_back(3);
        testVector.add(4,2);
        assertArrayEquals(new int[]{1,2,4,3},testVector.toArray());
        assertEquals(4,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @Test
    void add_then_higher_capacity()
    {
        testVector.push_back(8);
        for(int i = 0;i<8;i++)
            testVector.add(i,0);
        assertArrayEquals(new int[]{7,6,5,4,3,2,1,0,8},testVector.toArray());
        assertEquals(9,testVector.getSize());
        assertEquals(20,testVector.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void replace_if_out_of_bounds() throws RuntimeException
    {
        try{
            testVector.replace(1,0);
            throw new RuntimeException("Invalid operation");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertEquals("Index is out of bounds",e.getMessage());
        }


    }

    @Test
    void often_replace()
    {
        testVector.push_back(1);
        testVector.push_back(2);
        testVector.push_back(3);
        testVector.replace(4,2);
        assertArrayEquals(new int[]{1,2,4},testVector.toArray());
        assertEquals(3,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void delete_if_out_of_bounds() throws RuntimeException {
        try{
            testVector.delete(0);
            throw new RuntimeException("Invalid operation");
        }
        catch(IndexOutOfBoundsException e)
        {
            assertEquals("Index is out of bounds",e.getMessage());
        }
    }

    @Test
    void often_delete()
    {
        testVector.push_back(1);
        testVector.push_back(2);
        testVector.push_back(3);
        testVector.delete(1);
        assertArrayEquals(new int[]{1,3},testVector.toArray());
        assertEquals(2,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @org.junit.jupiter.api.Test
    void getSize_if_empty() {
        assertEquals(0,testVector.getSize());
    }

    @Test
    void often_getSize()
    {
        testVector.push_back(1);
        testVector.push_back(2);
        testVector.push_back(3);
        assertEquals(3,testVector.getSize());
    }

    @org.junit.jupiter.api.Test
    void getCapacity() {
        assertEquals(10,testVector.getCapacity());
    }


    @org.junit.jupiter.api.Test
    void get_if_out_of_bounds() throws RuntimeException
    {
        try {
            testVector.get(0);
            throw new RuntimeException("Invalid operation");
        }
        catch (IndexOutOfBoundsException e)
        {
            assertEquals("Index is out of bounds",e.getMessage());
        }
    }

    @Test
    void often_get()
    {
        testVector.push_back(1);
        testVector.push_back(2);
        testVector.push_back(3);
        assertEquals(3,testVector.get(2));
    }

    @org.junit.jupiter.api.Test
    void often_resize() {
        testVector.resize(4);
        assertEquals(4,testVector.getSize());
        assertEquals(10,testVector.getCapacity());
    }

    @Test
    void resize_if_higher_capacity()
    {
        testVector.resize(6);
        assertEquals(6,testVector.getSize());
        assertEquals(12,testVector.getCapacity());
    }

    @Test
    void toArray_if_empty()
    {
        assertArrayEquals(new int[]{},testVector.toArray());
    }

    @Test
    void often_toArray()
    {
        testVector.push_back(1);
        testVector.push_back(2);
        testVector.push_back(3);
        assertArrayEquals(new int[]{1,2,3},testVector.toArray());
    }

}
