package dataStructure;

public class implementSingleLL {
    public static void main(String[] args) {
        // SingleLinkedList list = new SingleLinkedList();
        // list.addFirst(10);
        // list.addFirst(20);
        // list.addFirst(30);
        // list.addFirst(40);
        // list.addLast(60);
        // list.insertAfterIndex(13, 0);
        // list.insertBeforeIndex(4, 1);
        // list.display();
        // System.out.println(list.getSize()+" before size");
        // list.insertBeforeIndex(12, 6);
        // list.deleteFirst();
        // list.deleteLast();
        // list.deleteIndex(0);
        // list.display();
        // System.out.println("Size is " + list.getSize());
        // System.out.println("Next node is " + list.getNextNode(30)); // node not exists

        // DoublyLinkedList dl = new DoublyLinkedList();

        // dl.addFirst(5);
        // dl.addFirst(4);
        // dl.addFirst(3);
        // dl.addFirst(2);
        // dl.addFirst(1);
        // dl.addFirst(9);
        // dl.addLast(11);
        // dl.addFirst(8);
        // dl.display();
        // System.out.println("Size  before is " + dl.getSize());
        // dl.insertAfterIndex(45, 1);
        // dl.display();
        // dl.insertBeforeIndex(33, 4);
        // dl.display();
        // dl.deleteFirst();
        // dl.display();
        // dl.deleteLast();
        // dl.deleteLast();
        // dl.deleteIndex(-1);
        // dl.display();
        // System.out.println("Get next node "+ dl.getNextNode(0));
        // System.out.println("Size is " + dl.getSize());
        // System.out.println("Get prev node "+ dl.getPrevNode(0));

        CircularLinkedList cl = new CircularLinkedList();
        cl.addFirst(5);
        cl.addFirst(4);
        cl.addFirst(3);
        cl.addFirst(2);
        cl.addFirst(1);
        cl.addLast(7);
        cl.display();
        cl.deleteFirst();
        cl.display();
        cl.deleteLast();
        cl.display();
        cl.deleteLast();
        cl.display();
        cl.insertAfterIndex(12,2);
        cl.insertAfterIndex(14,1);
        cl.insertBeforeIndex(11, 1);
        cl.display();
    }
}
