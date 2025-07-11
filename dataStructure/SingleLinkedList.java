package dataStructure;

public class SingleLinkedList {
    public Node head; // head will point to an instance of a Node so type is node
    public Node tail; // tail will point to an instance of a Node so type is node
    private int size; // increment the size when something is added or may be removed

    SingleLinkedList() {
        head = null; // during intialize the head and tail will be null
        tail = null;
        size = 0; // size =0
    }

    public void addFirst(int value) {
        Node node = new Node(value); // when value is added new node instance is created
        node.next = head; // node next will point to the current head node
        head = node; // head will point to the new node

        if (tail == null) // means if the list is empty
            tail = head; // head and tail will be same else dont change while adding in first

        size++; // increment the size to keep track of size;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (tail != null) { // means value is present
            tail.next = node; // make the new node the tail.next
            tail = node;
        } else { // means no element present
            head = node; // make the new node the head
            tail = head; // make the new node the tail
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
        head = head.next;
        if (head == null)
            tail = null;
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
        } else
            temp.next = null;
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

    // *****---------questions-------******
    public void insert(int value, int index) { // google question
        if (index < 0)
            throw new Error("Invalid index");
        head = insertRecusrion(value, index, head);
    }

    private Node insertRecusrion(int value, int index, Node nextTemp) {
        if (index == 0) {
            Node node = new Node(value, nextTemp);
            size++;
            return node;
        }
        nextTemp.next = insertRecusrion(value, index - 1, nextTemp.next);
        return nextTemp;
    }

    public void distinct() {
        Node temp = head;
        deleteDuplicates(temp);
        System.out.println(
                head.value + " next head " + head.next.value + " tail " + tail.value + " next tail " + tail.next);
    }

    public void deleteDuplicates(Node temp) { // leet code
        if (temp == null || temp.next == null)
            return;

        if (temp.value == temp.next.value) {
            temp.next = temp.next.next;
            deleteDuplicates(temp);
            size--;
            return;
        }
        deleteDuplicates(temp.next);
    }

    public SingleLinkedList merge(Node head1, Node head2) {
        SingleLinkedList list = new SingleLinkedList();
        list.head = mergeList(head1, head2);
        return list;
    }

    private Node mergeList(Node temp1, Node temp2) {
        if (temp1 == null && temp2 == null)
            return null;
        if (temp1 == null) {
            Node node = new Node(temp2.value);
            node.next = mergeList(temp1, temp2.next);
            tail = node;
            return node;
        }
        if (temp2 == null) {
            Node node = new Node(temp1.value);
            node.next = mergeList(temp1.next, temp2);
            tail = node;
            return node;
        }

        if (temp1.value < temp2.value) {
            Node node = new Node(temp1.value);
            node.next = mergeList(temp1.next, temp2);
            return node;
        } else {
            Node node = new Node(temp2.value);
            node.next = mergeList(temp1, temp2.next);
            return node;
        }
    }

    public boolean isInCycle(Node head) { // *****VIMP check whether cycle exists or not.Complexity O(n). fast slow
                                          // pointer method.
        Node f = head;
        Node s = head;
        boolean flag = false;
        int count = 1;
        while (f != null && f.next.next != null) {
            System.out.println(count + " counter");
            f = f.next.next;
            s = s.next;
            if (f == s)
                return !flag;
            count++;
        }
        return flag;
    }

    public int getMiddleNode(Node head) {
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s.value;
    }

    public Node getMiddleNodes(Node head) {
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        return s;
    }

    public SingleLinkedList sort(Node head) {
        try {
            Node temp = head;
            SingleLinkedList newList = new SingleLinkedList();
            while (temp.next != null)
                temp = temp.next;

            System.out.println("head " + head.value + " tail " + temp.value + "out class");
            sortInAction(head, temp, newList);
            return newList;
        } catch (Exception e) {
            System.out.println(e + " trace");
            return null;
        }
    }

    private void sortInAction(Node head, Node tail, SingleLinkedList newList) {
        if (head == null || head.next == tail)
            return;
        System.out.println("head " + head.value + " tail " + tail.value);
        Node temp = head;
        SingleLinkedList newList1 = new SingleLinkedList();
        Node mid = getMiddleNodes(temp);
        newList1.head = head;
        newList1.tail = mid;
        sortInAction(newList1.head, newList1.tail, newList); // left side
        sortInAction(mid.next, tail, newList); // right side
        merge(head, mid, tail, newList);
    }

    private void merge(Node head, Node mid, Node tail, SingleLinkedList newList) {
        Node temp = head;
        Node tailTemp = mid;
        while (temp != mid.next && tailTemp != tail.next && temp != null && tailTemp != null) {
            if (temp.value < tailTemp.value) {
                newList.addLast(temp.value);
                temp = temp.next;
            } else {
                newList.addLast(tailTemp.value);
                tailTemp = tailTemp.next;
            }
        }
        while (temp != mid.next && temp != null) {
            newList.addLast(temp.value);
            temp = temp.next;
        }
        while (tailTemp != tail.next && tailTemp != null) {
            newList.addLast(tailTemp.value);
            tailTemp = tailTemp.next;
        }
    }

    // *****------------***********
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

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
