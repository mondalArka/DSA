package dataStructure;

public class Queue {
    protected int size = 0;
    private static final int DEFAULT_SIZE = 10;
    protected int ptr = -1;
    protected int[] data;

    public Queue(int size){
        this.data = new int[size];
    }

    public Queue(){
        this(DEFAULT_SIZE);
    }

    protected boolean isFull() {
        return ptr == this.data.length-1;
    }

    protected boolean isEmpty() {
        return this.data.length == 0;
    }

    protected void shift() {
        for (int i = 0; i < ptr; i++)
            this.data[i] = this.data[i + 1];

        --ptr;
        --size;
    }

    public boolean push(int value) throws Exception {
        if (isFull())
            throw new Exception("Queue is full");

        this.data[++ptr] = value;
        ++size;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");

        int val = this.data[0];
        this.shift();
        return val;
    }

    protected int front() {
        return this.data[0];
    }

    public int size() {
        return size;
    }

    public void display() {
        for(int i=0;i<=ptr;i++)
            System.out.print(this.data[i]+" ");

        System.out.println();
    }
}
