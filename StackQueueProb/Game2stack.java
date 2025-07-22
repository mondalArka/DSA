package StackQueueProb;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Game2stack {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the sum");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        // s1.push(1);
        // s1.push(6);
        // s1.push(4);
        // s1.push(2);
        // s1.push(4);
        // s2.push(5);
        // s2.push(8);
        // s2.push(1);
        // s2.push(2);
        s1.push(5);
        s1.push(4);
        s1.push(3);
        s1.push(2);
        s1.push(1);
        s2.push(9);
        s2.push(8);
        s2.push(7);
        s2.push(6);
        System.out.println("max ways " + remove(s1, s2, n));
    }
 
    public static int remove(Stack<Integer> s1, Stack<Integer> s2, int n) {
        System.out.println("n " + n);
        if (n <= 0)
            return 0;
        if (s1.peek() < s2.peek() && s1.peek() <= n)
            n -= s1.pop();
        else if (s2.peek() < s1.peek() && s2.peek() <= n)
            n -= s2.pop();
        else
            return 0;
 
        return 1 + remove(s1, s2, n);
    }
}