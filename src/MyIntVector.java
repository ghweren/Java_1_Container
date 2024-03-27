import java.util.NoSuchElementException;

/**
 * Container class, for storing integers
 */
public class MyIntVector {
    /**
     * The number of numbers in the container is 0 by default
     */
    private int size=0;
    /**
     * Array of stored numbers
     */
    private int[] arr;
    /**
     * The capacity of the array of numbers, by default, is 10
     */
    private int capacity=10;

    /**
     *A private method used to increase the array of numbers when the size limit is reached
     * @param capacity Installed capacity
     * @throws IllegalArgumentException when trying to set a value below the current capacity
     */
    private void increase_the_capacity(int capacity) throws IllegalArgumentException
    {
        if(capacity<=this.capacity)
            throw new IllegalArgumentException("Illegal capacity");
        int[] temp = arr.clone();
        this.capacity=capacity;
        arr = new int[capacity];
        for(int i=0;i<size;i++)
            arr[i]=temp[i];
    }

    /**
     * Default constructor: creates an int array of length 10
     */
    public MyIntVector() {
        arr=new int[capacity];
    }

    /**
     * A constructor that creates an array of length 10 or size*2 if size*2 is greater than 10
     * @param size Number of numbers
     * @throws IllegalArgumentException when creating with size less than 0
     */
    public MyIntVector(int size) throws IllegalArgumentException
    {
        if(size<0)
            throw new IllegalArgumentException("Illegal size");
        this.size=size;
        if(size>0.5*capacity)
            capacity=2*size;
        else capacity=10;
        arr=new int[capacity];
    }

    /**
     * Inserting an element at the end of the container
     * @param element the inserted element
     */
    public void push_back(int element)
    {
        size++;
        if(size>capacity*0.8)
            increase_the_capacity(capacity*2);
        arr[size-1]=element;
    }

    /**
     * Inserting an element at the beginning of the container
     * @param element the inserted element
     */
    public  void push_front(int element)
    {
        size++;
        if(size>0.8*capacity)
            increase_the_capacity(capacity*2);
        int[] temp = arr.clone();
        arr=new int[capacity];
        arr[0]=element;
        for(int i=1;i<size;i++)
            arr[i]=temp[i-1];
    }

    /**
     * Deletes an element at the end of the container
     * @return Returns a deleted item
     * @throws NoSuchElementException if the container is empty
     */
    public int pop_back() throws NoSuchElementException
    {
        if(size==0)
            throw new NoSuchElementException("Vector is empty");
        int[] temp=arr.clone();
        arr=new int[capacity];
        size--;
        for(int i =0;i<size;i++)
            arr[i]=temp[i];
        return  temp[size];
    }

    /**
     * Deletes the element at the beginning of the container
     * @return Returns a deleted item
     * @throws NoSuchElementException if the container is empty
     */
    public int pop_front() throws NoSuchElementException
    {
        if(size==0)
            throw new NoSuchElementException("Vector is empty");
        int[] temp=arr.clone();
        arr=new int[capacity];
        size--;
        for(int i =1;i<size+1;i++)
            arr[i-1]=temp[i];
        return  temp[0];
    }

    /**
     * Inserts an element by index, shifting the elements from the index to the right
     * @param element The inserted element
     * @param index index
     * @throws IndexOutOfBoundsException when the index value goes beyond the boundaries of the container
     */
    public void add(int element,int index) throws IndexOutOfBoundsException
    {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        else
        {
            size++;
            if(size>0.8*capacity)
                increase_the_capacity(capacity*2);
            int[] temp = arr.clone();
            arr[index]=element;
            for(int i=index+1;i<size;i++)
                arr[i]=temp[i-1];
        }
    }

    /**
     * Replaces an element by index
     * @param element The inserted element
     * @param index index
     * @throws IndexOutOfBoundsException when the index value goes beyond the boundaries of the container
     */
    public void replace(int element,int index) throws IndexOutOfBoundsException
    {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        else
        {
            arr[index]=element;
        }
    }

    /**
     * Deletes an item by index
     * @param index index
     * @throws IndexOutOfBoundsException when the index value goes beyond the boundaries of the container
     */
    public void delete(int index) throws IndexOutOfBoundsException
    {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        else
        {
            int[] temp=arr.clone();
            size--;
            arr=new int[capacity];
            for(int i=0;i<index;i++)
                arr[i]=temp[i];
            for(int i =index;i<size+1;i++)
                arr[i]=temp[i+1];
        }
    }

    /**
     * Returns the number of numbers in the container
     * @return the number of numbers in the container
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Returns the capacity of the container
     * @return container capacity
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Returns an element by index
     * @param index index
     * @return Element by index
     * @throws IndexOutOfBoundsException when the index value goes beyond the boundaries of the container
     */
    public int get(int index) throws IndexOutOfBoundsException
    {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException("Index is out of bounds");
            return arr[index];
    }

    /**
     * changes the length of the container, in case of a smaller change, the numbers on the right are deleted
     * @param size length
     * @throws IllegalArgumentException when entering a negative length value
     */
    public void resize(int size) throws IllegalArgumentException
    {
        if(size<0)
            throw new IllegalArgumentException("Illegal size");
        if(size>0.5*capacity)
            increase_the_capacity(size*2);
        int[] temp =arr.clone();
        arr=new int[capacity];
        if(this.size>size)
            for(int i=0;i<size;i++)
                arr[i]=temp[i];
        else
            for(int i=0;i<this.size;i++)
                arr[i]=temp[i];
        this.size=size;
    }

    /**
     * Leads the container to int[]
     * @return int[]
     */
    public int[] toArray()
    {
        int[] result = new int[size];
        for(int i=0;i<size;i++)
            result[i]=arr[i];
       return result;
    }
}
