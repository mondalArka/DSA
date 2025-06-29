package dataStructure;

public class SingleLinkedList {
    private Node head; // head will point to  an instance of a Node so type is node
    private Node tail; // tail will point to  an instance of a Node so type is node 
    private int size; // increment the size when something is added or may be removed

    SingleLinkedList() {
        head = null; // during intialize the head and tail will be null
        tail = null;
        size = 0; // size =0
    }

    void addFirst(int value) {
        Node node = new Node(value); // when value is added new node instance is created
        node.next = head; // node next will point to the current head node  
        head = node; // head will point to the new node

        if (tail == null) // means if the list is empty
            tail = head; // head and tail will be same else dont change while adding in first

        size++; // increment the size to keep track of size;
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
