package queues;

public class CustomQueue {
    private static final int DEFAULT_SIZE = 10;
    private int[] data;
    private int end;
    private int capacity;

    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.capacity = size;
        this.data = new int[size];
    }

    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }

        data[end++] = value;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int deletedValue = data[0];
        for (int i=1; i<end; ++i) {
            data[i-1] = data[i];
        }

        --end;
        return deletedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return Integer.MIN_VALUE;
        }
        return data[0];
    }

    private boolean isEmpty() {
        return end == 0;
    }

    private boolean isFull() {
        return end == capacity;
    }

    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(50);
        queue.insert(40);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.peek());
    }

}
