package dataStructure;
import java.util.Arrays;

public class DynamicQueue extends Queue {
    public DynamicQueue(int size) {
        super(size);
    }

    public DynamicQueue() {
        super();
    }

    private void copy() {
        int[] copied = Arrays.copyOf(this.data, this.data.length * 2);
        this.data = copied;
    }

    @Override
    public boolean push(int value) {
        if (isFull())
            copy();

        this.data[++ptr] = value;
        ++size;

        return true;
    }
}
