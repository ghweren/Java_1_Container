import java.util.NoSuchElementException;

public class MyIntVector {
    private int size;
    private int[] arr;
    private int capacity=10;

    private void increase_the_capacity(int capacity)
    {
        int[] temp = arr.clone();
        capacity*=2;
        arr = new int[capacity*2];
        for(int i=0;i<size;i++)
            arr[i]=temp[i];
    }

    public MyIntVector() {
        size=0;
        capacity=10;
        arr=new int[capacity];
    }
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

    public void push_back(int element)
    {
        size++;
        if(size>capacity*0.8)
            increase_the_capacity(capacity*2);
        arr[size-1]=element;
    }

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

    public int pop_back() throws NoSuchElementException
    {
        if(size==0)
            throw new NoSuchElementException("Vector is empty");
        int[] temp=arr.clone();
        arr=new int[capacity];
        size--;
        for(int i =0;i<size;i++)
            arr[i]=temp[i];
        return  temp[size+1];
    }

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
    public void replace(int element,int index) throws IndexOutOfBoundsException
    {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException("Index is out of bounds");
        else
        {
            arr[index]=element;
        }
    }

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
    public int getSize()
    {
        return size;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public int get(int index) throws IndexOutOfBoundsException
    {
        if(index<0||index>size-1)
            throw new IndexOutOfBoundsException("Index is out of bounds");
            return arr[index];
    }

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
}
