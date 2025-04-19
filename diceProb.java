import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class diceProb { // how many ways can something be formed vvimp
    public static void main(String[] args) throws IOException { // ?how many ways can 4 be made from a dice
        int[] diceArr = { 1, 2, 3,4,5,6  };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the face");
        int face= Integer.parseInt(br.readLine()); // face means the maximum value rolling dice face side can have like for a classic dice it can not exceed 6
        // ArrayList<ArrayList<Integer>> combos = findCombos(n, diceArr, new ArrayList<Integer>(),
        //         new ArrayList<>(new ArrayList<>()),0,n);

        // combos.forEach(x -> System.out.println(x));
        // dice("",n);
    //    ArrayList<String> arr= diceList("",n); // no face
       ArrayList<String> arr= diceFace("",n,face); // with face
       if(face<4) arr.add(""+n); // when the face is lower than n it will not consider n to be a candidate,
        // as the loop is running till <face and n so if n=4 and face is 3 will run till 3, so manually add the n.
       System.out.println(arr);
       
    }

    static void dice(String p ,int n){
        if(n==0){
            System.out.println(p);
        }

        for(int i=1; i<=n ;i++){
            dice(p+i, n-i);
        }
    }

    static ArrayList<String> diceList(String p ,int n){
        if(n==0){
            // System.out.println(p);
            ArrayList<String> arr= new ArrayList<>();
            arr.add(p);
            return arr;
        }

        ArrayList<String> arr= new ArrayList<>();
        for(int i=1; i<=n ;i++){
            arr.addAll(diceList(p+i, n-i));
        }

        return arr;
    }

    static ArrayList<String> diceFace(String p ,int n,int face){
        if(n==0){ // correct condition
            // System.out.println(p);
            ArrayList<String> arr= new ArrayList<>();
            arr.add(p);
            return arr;
        }

        ArrayList<String> arr= new ArrayList<>();
        for(int i=1; i<=face && i<=n ;i++){  // when face is 6 for every recursion,
            // it will go for 6 time in loop and the next value of n will go to negative and the loop run infinite cause 
            // n==0 is always false so recursion continues i<=face and less than n other wise loop will run till face. 
            arr.addAll(diceFace(p+i, n-i,face));
        }

        return arr;
    }
   
}
