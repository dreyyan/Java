package CustomDS;

public class DoublyLinkedList {
    private static class Node {
        // ATTRIBUTES: Node
        int value;
        Node prev;
        Node next;

        // CONSTRUCTOR: Node
        Node(int value) {
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        // METHODS: Node
        // Getters
        public int getValue() { return this.value; }
        public Node getNext() { return this.next; }
        public Node getPrev() { return this.prev; }

        // Setters
        public void setValue(int value) { this.value = value; }
        public void setNext(Node newNode) { this.next = newNode; }
        public void setPrev(Node newNode) { this.prev = newNode; }
    }

    // ATTRIBUTES: Linked List
    private int size;
    private Node head;
    private Node tail;

    // CONSTRUCTOR: Linked List
    DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        size = 1;
    }

    // METHODS: Linked List
    public void addAtHead(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        } ++size;
    }

    public void addAtTail(int value) {
        Node newNode = new Node(value);
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        } ++size;
    }

    public void removeAtHead() {
        if (this.head == null) return;
        if (head == tail) { // CASE: One Node
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        } --size;
    }

    public void removeAtTail() {
        if (this.head == null) return;
        if (head == tail) { // CASE: One Node
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
    }

    public boolean isEmpty() { return (this.size == 0); }

    public int getSize() {
        return this.size;
    }

    public void printForward() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void printBackward() {
        Node current = this.tail;
        while (current != null) {
            System.out.println(current.value);
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.addAtTail(4);
        linkedList.addAtTail(5);
        linkedList.printForward();
    }
}
