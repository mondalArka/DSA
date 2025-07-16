package dataStructure;

public class Stack {
    private int ptr = -1;
    private static final int DEFAULT_SIZE = 10;
    protected int[] data;

    public Stack(int size) {
        this.data = new int[size];
    }

    public Stack() {
        this(DEFAULT_SIZE);
    }

    private boolean isFull() {
        return ptr == this.data.length - 1;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    public boolean push(int item) {
        if (isFull())
            return false;

        this.data[++ptr] = item;
        return true;
    }

    public boolean pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");

        ptr--;
        return true;
    }

    public int peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return this.data[ptr];
    }

    public void display() {
        for (int i = 0; i <= ptr; i++) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }
}
