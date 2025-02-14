package stacks;

import java.util.EmptyStackException;

public class DynamicStack extends CustomStack {

    public DynamicStack(int value) {
        super(value);
    }

    @Override
    public boolean push(int value) {
        if (isFull()) {
            int[] temp = new int[size*2];
            if (size >= 0) System.arraycopy(data, 0, temp, 0, size);

            size *= 2;
            this.data = temp;
        }
        return super.push(value);
    }
}
