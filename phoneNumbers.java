import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class phoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the numbers");
        String str = br.readLine(); // start input from 2 not 1
        str = str.trim();
        // if (str.contains(" "));
        // throw new Error("Invalid input.Cannot have space");

        // My method
        ArrayList<String> newArr = nums("", str, 0, new ArrayList<String>()); //
        // holding the characters static
        System.out.println("-----------------");
        newArr.forEach(x -> System.out.println(x));

        //----------------------------------------------------------
        //  Kunals method
        // ArrayList<String> newArr2 = withoutSwitch("", str, 0, new ArrayList<>()); // without holding the characters
                                                                        // static
        System.out.println("-----------------"); // start input from 1
        // newArr2.forEach(x -> System.out.println(x));

    }

    static ArrayList<String> nums(String pick, String str, int s, ArrayList<String> arr) { // best method accurate one
        if (s - str.length() == 0) {
            // System.out.println("coms"+pick);
            arr.add(pick);
            return arr;
        }
        String newStr = "";
        switch (str.charAt(s)) {
            case '2': {
                newStr = "abc";
                break;
            }

            case '3': {
                newStr = "def";
                break;
            }

            case '4': {
                newStr = "ghi";
                break;
            }
            case '5': {
                newStr = "jkl";
                break;
            }

            case '6': {
                newStr = "mno";
                break;
            }

            case '7': {
                newStr = "pqrs";
                break;
            }

            case '8': {
                newStr = "tuv";
                break;
            }

            case '9': {
                newStr = "wxyz";
                break;
            }

            default:
                return arr;
        }
        for (int i = 0; i < newStr.length(); i++) {
            pick += newStr.charAt(i);
            nums(pick, str, s + 1, arr);
            pick = pick.substring(0, s);
        }

        return arr;
    }

    static ArrayList<String> withoutSwitch(String pick, String str, int s, ArrayList<String> arr) {
        {
            if (s - str.length() == 0) {
                // System.out.println(pick);
                arr.add(pick);
                return arr;
            }

            int digit = Integer.parseInt("" + str.charAt(s));
            int end;
            int start = (digit - 1) * 3;
            if (str.charAt(s) == '9')
                end = digit * 3 - 2;
            else
                end = digit * 3 - 1;
            for (int i = start; i <= end; i++) {
                pick += (char) ('a' + i);
                withoutSwitch(pick, str, s + 1, arr);
                pick = pick.substring(0, s);
            }
            return arr;
        }
    }
}
