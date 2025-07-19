package dataStructure;
 
public class queueImplement {
    public static void main(String[] args) throws Exception {
        Queue q = new Queue();
 
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.push(7);
        q.push(8);
        q.push(9);
        q.push(6);
        q.push(10);
        // q.push(14);
 
        System.out.println("start "+q.size());
        q.display();
        q.remove();
        System.out.println("after pop "+q.size());
        q.display();
        q.push(34);
        System.out.println("end "+q.size());
        q.remove();
        q.display();
        System.out.println("peek "+q.front());
 
        CircularQueue cq = new CircularQueue();
 
        cq.push(1);
        cq.push(2);
        cq.push(3);
        cq.push(4);
        cq.push(5);
        cq.push(7);
        cq.push(8);
        cq.push(9);
        cq.push(6);
        cq.push(10);
        cq.push(14);
 
        System.out.println("before size "+cq.size()+" front "+cq.front);
        cq.display();
        System.out.println("front "+cq.front()+" front1111111 "+cq.front);
 
        cq.remove();
        System.out.println("after size "+cq.size()+" front22222222 "+cq.front);
        cq.display();
        cq.remove();
        System.out.println("after size2 "+cq.size()+" front3333333 "+cq.front);
        cq.display();
        System.out.println("front in "+cq.front+" rear "+cq.rear+" size "+cq.size());
        cq.push(99);
        System.out.println("front in "+cq.front+" rear "+cq.rear+" size "+cq.size());
        cq.display();

        DynamicQueue  dq = new DynamicQueue();
        dq.push(1);
        dq.push(2);
        dq.push(3);
        dq.push(4);
        dq.push(5);
        dq.push(7);
        dq.push(8);
        dq.push(9);
        dq.push(6);
        dq.push(10);
        dq.push(14);
        dq.push(15);

        dq.display();
        System.out.println("front dq "+dq.front());
        System.out.println("size "+dq.size());
        dq.remove();
        dq.display();
        System.out.println("front dq "+dq.front());
        System.out.println("size "+dq.size());
    }
}