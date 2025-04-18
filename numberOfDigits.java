import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class numberOfDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n= Integer.parseInt(br.readLine());

        int count = (int) Math.log10(n)+1;
        System.out.println(count+" count");
    }
}
