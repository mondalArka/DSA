package dataStructure;

public class stackImplement {
    public static void main(String[] args) throws Exception {
        Stack stack1 = new Stack(5); // stack size is 5
        Stack stack2 = new Stack(); // default stack size is 10

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);

        stack2.push(8);
        stack2.push(9);
        stack2.push(10);
        stack2.push(11);
        stack2.push(12);
        stack2.push(14);
        stack2.push(10);
        stack2.push(10);
        stack2.push(10);
        stack2.push(11);
        stack2.push(19);

        stack2.display();

        stack1.display();
        stack1.pop();
        stack1.display();
        System.out.println("peek "+stack1.peek());
    }
}
