package linked_lists;

/**
 * Considerations.
 * Think about head and tail
 * Think about empty and non-empty linked lists
 * Think about when the list contains single element and multiple elements
 *
 */

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAt(1, 0);
        dll.insertAt(2, 1);
        dll.display();

        dll.insertFirst(10);
        dll.insertFirst(20);
        dll.insertFirst(30);
        dll.insertFirst(40);
        dll.display();

        dll.insertLast(50);
        dll.display();

        dll.insertAt(3, 3);
        dll.insertLast(60);
        dll.display();

        dll.deleteFirst();
        dll.deleteLast();
        dll.display();

        dll.deleteAt(3);
        dll.display();
        dll.displayReverse();
    }

    private Node createNode(int value) {
        return new Node(value, null, null);
    }

    private Node get(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position");
        }

        Node temp = head;
        for (int i=0; i<position; ++i) {
            temp = temp.next;
        }

        return temp;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }

        System.out.println();
    }

    public void displayReverse() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.prev != null) {
                System.out.print(" -> ");
            }
            temp = temp.prev;
        }

        System.out.println();
    }

    public void insertFirst(int value) {
        Node node = createNode(value);
        if (head == null) {
            head = tail = node;
            ++size;
            return;
        }

        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;

        ++size;
    }

    public void insertLast(int value) {
        Node node = createNode(value);
        node.next = null;
        node.prev = tail;
        if (tail == null) {
            head = node;
            tail = node;
            return;
        }

        tail.next = node;
        tail = node;

        ++size;
    }

    public void insertAt(int value, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (position == 0) {
            insertFirst(value);
            return;
        }

        if (position == size) {
            insertLast(value);
            return;
        }

        Node node = createNode(value);
        Node nodeBeforePosition = get(position-1);
        Node nodeAtPosition = nodeBeforePosition.next;
        node.prev = nodeBeforePosition;
        node.next = nodeAtPosition;
        nodeBeforePosition.next = node;
        nodeAtPosition.prev = node;
        ++size;
    }

    public int deleteFirst() {
        if (head == null) {
            throw new RuntimeException("Cannot delete from an empty linked list.");
        }

        int deletedValue = head.value;

        if (head == tail) {
            head = tail = null;
            return deletedValue;
        }

        head = head.next;
        head.prev = null;
        --size;
        return deletedValue;
    }

    public int deleteLast() {
        if (head == null) {
            throw new RuntimeException("Cannot delete from an empty linked list.");
        }

        int deletedValue = tail.value;

        if (head == tail) {
            head = tail = null;
            return deletedValue;
        }

        tail = tail.prev;
        tail.next = null;
        --size;
        return deletedValue;
    }

    public int deleteAt(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (position == 0) {
            return deleteFirst();
        }

        if (position == size-1) {
            return deleteLast();
        }

        Node nodeBeforePosition = get(position-1);
        Node nodeAfterPosition = nodeBeforePosition.next.next;
        int deletedValue = nodeBeforePosition.next.value;
        nodeBeforePosition.next = nodeAfterPosition;
        nodeAfterPosition.prev = nodeBeforePosition;
        --size;
        return deletedValue;
    }
}
