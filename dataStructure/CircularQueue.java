package dataStructure;
 
public class CircularQueue {
    protected int[] data;
    protected int size = 0;
    protected int front = 0;
    protected int rear = 0;
    private static final int DEFAULT_SIZE = 10;
 
    public CircularQueue(int capacity) {
        this.data = new int[capacity];
    }
 
    public CircularQueue() {
        this(DEFAULT_SIZE);
    }
 
    public int size() {
        return this.size;
    }
 
    public boolean isFull() {
        return size == data.length;
    }
 
    public boolean isEmpty() {
        return size == 0;
    }
 
    public void push(int item) {
        data[rear] = item;
    
        if (size == data.length) {  // queue is full
            front = (front + 1) % data.length;  // overwrite oldest
        } else {
            size++;  // increase size only if not full
        }
    
        rear = (rear + 1) % data.length;
    }
    
 
    public boolean remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
 
        front = (front + 1) % data.length;
        size--;
        return true;
    }
 
    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
 
        return data[front];
    }
 
    public void display() {
        int count = size;
        int i = front;
 
        while (count-- > 0) {
            System.out.print(data[i] + " ");
            i = (i + 1) % data.length;
        }
        System.out.println();
    }
}
