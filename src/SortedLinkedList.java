public class SortedLinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Class<T> type;

    // Constructor for initializing with the type of values
    public SortedLinkedList(Class<T> type) {
        this.head = null;
        this.type = type;
    }

    // Method to add a new value
    public void add(T value) {
        if (!value.getClass().equals(type)) {
            throw new IllegalArgumentException("List only supports values of type: " + type.getSimpleName());
        }

        Node<T> newNode = new Node<>(value);

        if (head == null || head.value.compareTo(value) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<T> current = head;
        while (current.next != null && current.next.value.compareTo(value) < 0) {
            current = current.next;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to remove a value from the list
    public boolean remove(T value) {
        if (head == null) {
            System.out.println("List is empty. Cannot remove value: " + value);
            return false;
        }

        // Handle the case where we want to remove the head
        if (head.value.equals(value)) {
            head = head.next;
            System.out.println("Value " + value + " removed from the list.");
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                System.out.println("Value " + value + " removed from the list.");
                return true;
            }
            current = current.next;
        }

        System.out.println("Value " + value + " not found in the list.");
        return false;
    }

    // Method to check if the value exists in the list
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                System.out.println("Value " + value + " found in the list.");
                return true;
            }
            current = current.next;
        }
        System.out.println("Value " + value + " not found in the list.");
        return false;
    }

    // Method to print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    // Method to get the size of the list
    public int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Node class for linked list
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }
}