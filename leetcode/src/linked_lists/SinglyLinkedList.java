package linked_lists;

/**
 * Considerations.
 * Think about head and tail
 * Think about empty and non-empty linked lists
 * Think about when the list contains single element and multiple elements
 *
 */

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAt(1, 0);
        sll.insertAt(2, 1);
        sll.insertFirst(10);
        sll.insertFirst(20);
        sll.insertFirst(30);
        sll.insertFirst(40);
        sll.insertLast(50);
        sll.insertAt(3, 3);
        sll.insertLast(60);
        sll.display();

        sll.deleteFirst();
        sll.deleteLast();
        sll.display();

        sll.deleteAt(6);
        sll.display();
    }

    private Node createNode(int value) {
        return new Node(value);
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

    public void insertFirst(int value) {
        Node node = createNode(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }

        ++size;
    }

    public void insertLast(int value) {
        Node node = createNode(value);
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
        node.next = nodeBeforePosition.next;
        nodeBeforePosition.next = node;
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

        Node secondLastNode = get(size-2);
        secondLastNode.next = null;
        tail = secondLastNode;
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
        int deletedValue = nodeBeforePosition.next.value;
        nodeBeforePosition.next = nodeBeforePosition.next.next;

        --size;

        return deletedValue;
    }
}
