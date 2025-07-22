package pracStructure;

public class TwoStackQueue { // making queue using two stacks

    protected int size;
    private static final int DEFAULT_SIZE = 5;
    protected int ptr = -1;
    private int[] main;
    private int[] temp;

    public TwoStackQueue(int size) {
        this.main = new int[size];
        this.temp = new int[size];
    }

    public TwoStackQueue() {
        this(DEFAULT_SIZE);
    }

    private void arrange() {
        int j = ptr;
        for (int i = 0; i <= ptr; i++) {
            this.temp[i] = this.main[j];
            j--;
        }
        this.main = new int[this.main.length];
    }

    private void reArrange() {
        int i = 0;
        for (int j = ptr; j >= 0; j--) {
            this.main[i] = this.temp[j];
            i++;
        }
        this.temp = new int[this.main.length];
    }

    public boolean empty() {
        return ptr == -1;
    }

    private boolean full() {
        return ptr == this.main.length - 1;
    }

    public int size() {
        return size;
    }

    public boolean push(int value) throws Exception {
        if (full())
            throw new Exception("Queue is full");

        this.main[++ptr] = value;
        size++;

        return true;
    }

    public boolean remove() throws Exception {
        if (empty())
            throw new Exception("Queue is empty");

        arrange();
        --ptr;
        --size;
        reArrange();

        return true;
    }

    public void display() {
        for (int i = 0; i <= ptr; i++)
            System.out.print(this.main[i] + " ");

        System.out.println();
    }

    public int peek() throws Exception {
        if(empty())
            throw new Exception("Queue is empty");
        return this.main[0];
    }
}
