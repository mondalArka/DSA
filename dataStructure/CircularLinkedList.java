package dataStructure;

public class CircularLinkedList {
    private Node head; // head will point to an instance of a Node so type is node
    private Node tail; // tail will point to an instance of a Node so type is node
    private int size; // increment the size when something is added or may be removed

    CircularLinkedList() {
        head = null; // during intialize the head and tail will be null
        tail = null;
        size = 0; // size =0
    }

    public void addFirst(int value) {
        Node node = new Node(value); // when value is added new node instance is created
        node.next = head; // node next will point to the current head node
        head = node; // head will point to the new node

        if (tail == null) { // means if the list is empty
            tail = head; // head and tail will be same else dont change while adding in first
            tail.next = head;
        } else
            tail.next = head; // point the tail tnext to the head or the new node

        size++; // increment the size to keep track of size;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (tail != null) { // means value is present
            tail.next = node; // make the new node the tail.next
            tail = node;
            tail.next = head;
        } else { // means no element present
            head = node; // make the new node the head
            tail = node; // make the new node the tail
            tail.next = node;
        }
        size++;
    }

    public int getNextNode(int currentValue) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == currentValue && temp.next != null)
                return temp.next.value;

            temp = temp.next;
        }
        return -1;
    }

    public void insertAfterIndex(int value, int index) {
        if (index > size - 1 || index < 0)
            throw new Error("Invalid index");
        Node temp = head;
        int i = 0;
        while (i <= (size - 1)) {
            if (i == index)
                break;

            i++;
            temp = temp.next;
        }

        if (temp == tail)
            addLast(value);

        else {
            Node node = new Node(value);
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }

    public void insertBeforeIndex(int value, int index) {
        if (index <= 0 || index > (size - 1)) // index 0 inser6tion is not allowed cause
            throw new Error("Invalid index");
        Node temp = head;
        int i = 0;
        while (i <= (size - 1)) {
            if (i == index - 1)
                break;
            i++;
            temp = temp.next;
        }
        if (temp == head)
            addFirst(value);
        else {
            Node node = new Node(value); // same as insertAfterIndex
            node.next = temp.next;
            temp.next = node;
            // insertAfterIndex(value, index-1); // can do this also
            size++;
        }
    }

    public void deleteFirst() {
        if (head == null)
            throw new Error("List is empty"); // can also return no need to throw error
        else if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }

    public void deleteLast() {
        if (head == null)
            throw new Error("List is empty");
        Node temp = head;
        for (int i = 0; i < size - 2; i++)
            temp = temp.next;

        if (head == tail) {
            head = null;
            tail = null;
            size--;
        } else {
            temp.next = head;
            tail = temp;
        }
        size--;
    }

    public void deleteIndex(int index) {
        if (size == 0)
            throw new Error("List is empty");

        if (index > size - 1 || index < 0)
            throw new Error("Invalid index");

        if (size == 1) {
            tail = null;
            head = null;
            size--;
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;
        int i = 0;
        while (i <= (size - 1)) {
            if (i == (index - 1))
                break;
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        size--;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            if (temp != tail)
                System.out.print(temp.value + " -> ");
            else if (temp == tail) { // to check if tail has been found then print tail and the head to check the
                // circular structure and break
                System.out.print(temp.value + " -> " + temp.next.value + "..");
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    private class Node { // actual node instance
        private int value; // value of the current node
        private Node next; // next points to the a node instance so type is node

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
