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

    public void sortAction(Node head) {
        // if(head != null && head.next != null)
        // return null;

        Node temp = head;
        boolean swapped = false;
        do { // bubble sort
            swapped = false;
            temp = head;
            do {
                if (temp.next == null)
                    return;
                // System.out.println("xxxxxx");
                // System.out.println(temp.value + " old");
                swapped = false;
                if (temp.value > temp.next.value) {
                    int tempVal = temp.value;
                    temp.value = temp.next.value;
                    temp.next.value = tempVal;
                    swapped = true;
                }
                // System.out.println(temp.value+" old "+temp.next.value);
                temp = temp.next;
                // System.out.println(temp.value+" new "+temp.next.value);
            } while ((temp != null && temp.next != null));
        } while (swapped);
    }

    public SingleLinkedList sort(Node head) {
        Node left = getMiddleNodes(head);
        Node right = getMiddleNodes(left.next);
        SingleLinkedList newList = new SingleLinkedList();
        System.out.println("left " + left.value + " right " + right.value);
        sortAction(left);
        sortAction(right);
        newList.head = mergeList(left, right);
        return newList;
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

    public SingleLinkedList reverse(SingleLinkedList list) {
        // SingleLinkedList list = new SingleLinkedList();
        // Node tempHead = list.head;
        // list.head = reverseAction(tempHead);
        // list.tail = tempHead; // using loop technique
        reverseRecursion(list.head); // using recursion
        return list;

    }

    public Node reverseAction(Node head) {
        Node temp = head;
        Node current = temp.next;
        Node prev = null;

        while (current != null) {
            temp.next = prev;
            prev = temp;
            temp = current;
            current = current.next;
        }

        // Final node still needs its pointer reversed
        temp.next = prev;

        return temp; // temp is now the new head
    }

    public void reverseRecursion(Node node) {
        if (node == tail) {
            head = tail;
            return;
        }

        reverseRecursion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void reversePart(Node head, int left, int right) {
        if ((left == right) || (left > right))
            return;
        Node leftHead = head;
        Node rightHead = head;
        int i = 0;
        while (i != left) {
            leftHead = leftHead.next;
            i++;
        }
        i = 0;
        while (i != right) {
            rightHead = rightHead.next;
            i++;
        }
        int val;
        val = leftHead.value;
        leftHead.value = rightHead.value;
        rightHead.value = val;
        reversePart(head, left + 1, right - 1);
    }

    public boolean isPalindrome(Node head) {
        if (head == tail)
            return true;
        Node temp = head;
        Node mid = getMiddleNodes(head);
        if (mid.next == null) {
            if (head.value == head.next.value)
                return true;

            return false;
        }
        ;
        temp = mid.next;
        Node befMid = head;

        while (befMid.next != temp)
            befMid = befMid.next;

        Node revHead = reverseAction(temp);
        befMid.next = revHead;
        Node s = head;
        Node f = revHead;
        while (f != null && s.value == f.value) {
            f = f.next;
            s = s.next;
        }

        mid = getMiddleNodes(revHead);
        befMid.next = reverseAction(revHead);
        if (f != null)
            return false;

        return true;
    }

    public void reOrder(Node head){
        if (head == null || head.next == null) return;
        Node first =head;
        Node mid = getMiddleNodes(head);
        Node second = reverseAction(mid.next);
        mid.next= null;
        while(second!=null){
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
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
