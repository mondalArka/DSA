package dataStructure;

public class DoublyLinkedList {
    private Node head; // head will point to an instance of a Node so type is node
    private Node tail; // tail will point to an instance of a Node so type is node
    private int size; // increment the size when something is added or may be removed

    DoublyLinkedList() {
        head = null; // during intialize the head and tail will be null
        tail = null;
        size = 0; // size =0
    }

    public void addFirst(int value) {
        Node node = new Node(value); // when value is added new node instance is created
        if (head != null) // if head is null then cant set the head.prev to the new node as it is null
            head.prev = node; // point the current node prev to the new node

        node.next = head; // node next will point to the current head node
        head = node; // head will point to the new node

        if (tail == null) // means if the list is empty
            tail = head; // head and tail will be same else dont change while adding in first

        size++; // increment the size to keep track of size;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (tail != null) { // means value is
            node.prev = tail;
            tail.next = node; // make the new node the tail.next
            tail = node;
        } else // means no element present
            addFirst(value);// make the new node the tail

        size++;
    }

    public int getNextNode(int index) {
        if (size == 0)
            throw new Error("List is empty");
        if (index > size - 1 || index < 0)
            throw new Error("Invalid index");

        if (index == (size - 2))
            return tail.value;

        Node temp = head;
        int i = 0;
        while (i <= (size - 1)) {
            if (i == index)
                return temp.next != null ? temp.next.value : -1;

            i++;
            temp = temp.next;
        }
        return -1;
    }

     public int getPrevNode(int index) {
        if (size == 0)
            throw new Error("List is empty");
        if (index > size - 1 || index < 0)
            throw new Error("Invalid index");

        if (index == (size - 2))
            return tail.value;

        Node temp = head;
        int i = 0;
        while (i <= (size - 1)) {
            if (i == index)
                return temp.prev != null ? temp.prev.value : -1;

            i++;
            temp = temp.next;
        }
        return -1;
    }

    public void insertAfterIndex(int value, int index) {
        if (size == 0)
            throw new Error("List is empty");

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
            node.prev = temp; // set the previous node
            node.next = temp.next; // set the next node for the new node
            if (temp.next != null)
                temp.next.prev = node; // set the temp.next's previous node to the new node and check it is not null

            temp.next = node; // now set the temp.next to the new node
            size++;
        }
    }

    public void insertBeforeIndex(int value, int index) {
        if (size == 0)
            throw new Error("List is empty");

        if (index <= 0 || index > (size - 1))
            throw new Error("Invalid index");
        Node temp = head;
        int i = 0;
        while (i <= (size - 1)) {
            if (i == (index - 1))
                break;
            i++;
            temp = temp.next;
        }
        if (temp == head)
            addFirst(value);
        else {
            Node node = new Node(value); // same as insertAfterIndex
            node.prev = temp;
            node.next = temp.next;
            if (temp.next != null)
                temp.next.prev = node;
            temp.next = node;
            // insertAfterIndex(value, index-1); // can do this also
            size++;
        }
    }

    public void deleteFirst() {
        if (head == null)
            throw new Error("List is empty"); // can also return no need to throw error
        head = head.next;
        head.prev = null;
        if (head == null)
            tail = null;
        size--;
    }

    public void deleteLast() {
        if (head == null)
            throw new Error("List is empty");
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;

        if (head == tail) {
            head = null;
            tail = null;
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

        Node temp = head.next;
        int i = 1;
        while (i <= (size - 1)) {
            if (i == index)
                break;
            temp = temp.next;
            i++;
        }

        temp.prev.next = temp.next; // set the previous node's next to the next node skipping the current node
        temp = temp.next; // set the previous node's next to the next node skipping the current node
        size--;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node { // actual node instance
        private int value; // value of the current node
        private Node next; // next points to the a node instance so type is node
        private Node prev; // to point to previous node

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}
