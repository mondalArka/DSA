package pracStructure;

public class implement2StackQueue {
    public static void main(String[] args) throws Exception {
        TwoStackQueue ts= new TwoStackQueue();

        ts.push(1);
        ts.push(2);
        ts.push(3);
        ts.push(4);
        // ts.push(5);
        // ts.push(6);

        ts.display();
        System.out.println("size bef "+ts.size());
        ts.remove();
        System.out.println("after size "+ts.size());
        ts.display();
        System.out.println("peek "+ts.peek());
        ts.push(5);
        System.out.println("last size "+ts.size());
        ts.display();
        int queSize = ts.size();
        for(int i=0;i<queSize;i++){
            System.out.println(i+" jujuj "+ts.size());
            ts.remove();
        }

        System.out.println("size ee "+ts.size());
        // System.out.println("afetr peek "+ts.peek());
        // ts.remove();
        ts.display();

    }
}
