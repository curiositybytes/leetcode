package CustomImplementations.Set;

import java.util.ArrayList;

public class CustomSetUsingArrayList<T> {
    final private ArrayList<T> elements;

    public CustomSetUsingArrayList() {
        elements = new ArrayList<>();
    }

    // Add an element to the set
    public boolean add(T element) {
        if (!contains(element)) {
            elements.add(element);
            return true;
        }
        return false;
    }

    // Remove an element from the set
    public boolean remove(T element) {
        return elements.remove(element);
    }

    // Check if the set contains an element
    public boolean contains(T element) {
        for (T e : elements) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Return the size of the set
    public int size() {
        return elements.size();
    }

    // Display all elements in the set
    public void display() {
        System.out.println(elements);
    }

    public static void main(String[] args) {
        CustomSetUsingArrayList<String> set = new CustomSetUsingArrayList<>();
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
