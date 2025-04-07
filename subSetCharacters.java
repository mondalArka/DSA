import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class subSetCharacters {

    static int k = 0;
    static int chars = 0;
    static String[] arr = new String[(int) (Math.pow(2, 4)-1)];

    public static void main(String[] args) throws IOException { // inplace subset
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        subSets("", str,0);
        System.out.println("Subsets " + Arrays.toString(arr));
    }

    static void subSets(String pick, String actualStr,int s) {
        // System.out.println("Actual str "+actualStr+" picked "+pick+" k "+k);
        if (s > actualStr.length()-1 ) {
            if(pick!=""){
                System.out.println("Subset is " + pick);
                arr[k]=pick;
                k++;
            }
            return;
        }

        char ch = actualStr.charAt(s);
        System.out.println("picked ----------------");
        subSets(pick + ch, actualStr,s+1);
        System.out.println("Not picked ------------------");
        subSets(pick, actualStr,s+1);
    }
}
