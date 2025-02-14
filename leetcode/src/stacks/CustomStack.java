package stacks;

import java.util.EmptyStackException;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int size;
    private int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.size = size;
        this.data = new int[size];
    }

    public boolean push(int value) {
        if (isFull()) {
            throw new StackOverflowError("Cannot push: Stack is full");
        }

        data[++ptr] = value;
        return true;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return data[ptr--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return data[ptr];
    }

    private boolean isEmpty() {
        return ptr == -1;
    }

    protected boolean isFull() {
        return ptr == size-1;
    }

    public static void main(String[] args) {
        CustomStack stack = new DynamicStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
