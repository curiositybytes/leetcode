package queues;

public class CircularQueue {
    private static final int DEFAULT_SIZE = 10;
    private int[] data;
    private int front;
    private int end;
    private int capacity;
    private int size;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.capacity = size;
        this.data = new int[size];
    }

    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }

        data[end++] = value;
        end %= capacity;
        ++size;
        return true;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int deletedValue = data[front++];
        front %= capacity;
        --size;
        return deletedValue;
    }

    public int peek() {
        return data[front];
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(50);
        queue.insert(40);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println();
        queue.insert(10);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
