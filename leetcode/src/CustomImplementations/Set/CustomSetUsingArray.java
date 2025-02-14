package CustomImplementations.Set;

import java.util.Arrays;

public class CustomSetUsingArray<T> {
    private Object[] elements; // Array to store elements
    private int size;          // Current size of the set
    private static final int INITIAL_CAPACITY = 10; // Initial array size

    public CustomSetUsingArray() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Add an element to the set
    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    // Remove an element from the set
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                elements[i] = elements[size - 1]; // Replace with the last element
                elements[size - 1] = null; // Remove last element
                size--;
                return true;
            }
        }
        return false;
    }

    // Check if the set contains an element
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Return the size of the set
    public int size() {
        return size;
    }

    // Display all elements in the set
    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(elements[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Ensure the array has enough capacity
    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2); // Double the size
        }
    }

    public static void main(String[] args) {
        CustomSetUsingArray<String> set = new CustomSetUsingArray<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate, won't be added
        set.display();
        System.out.println("Contains Banana: " + set.contains("Banana"));
        set.remove("Banana");
        set.display();
        System.out.println("Set size: " + set.size());
    }
}
