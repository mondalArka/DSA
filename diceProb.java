import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class diceProb { // how many ways can something be formed vvimp
    public static void main(String[] args) throws IOException { // ?how many ways can 4 be made from a dice
        int[] diceArr = { 1, 2, 3,4,5,6  };
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        // ArrayList<ArrayList<Integer>> combos = findCombos(n, diceArr, new ArrayList<Integer>(),
        //         new ArrayList<>(new ArrayList<>()),0,n);

        // combos.forEach(x -> System.out.println(x));
        dice("",n);
    }

    // static ArrayList<ArrayList<Integer>> findCombos(
    //     int search,int[] arr, 
    //     ArrayList<Integer> pick, 
    //     ArrayList<ArrayList<Integer>> newArr,
    //     int sum,
    //     int actualSearch
    //     ){
    //         if(search<=0 ) {
    //             if(sum==actualSearch){
    //                 newArr.add(new ArrayList<>(pick));
    //                 return newArr;
    //             }else return newArr;
    //         }
    //         for(int i=0;i<arr.length;i++){
    //             sum+=arr[i];
    //             pick.add(arr[i]);
    //             findCombos(search-arr[i], arr, pick, newArr,sum,actualSearch);
    //             pick.remove(pick.size()-1);
    //             sum-=arr[i];
    //         }

    //         return newArr;
    // }

    static void dice(String p ,int n){
        if(n==0){
            System.out.println(p);
        }

        for(int i=1; i<=n ;i++){
            dice(p+i, n-i);
        }
    }
   
}
