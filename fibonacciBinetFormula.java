import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class fibonacciBinetFormula {
    public static void main(String[] args) throws IOException {
        // Binnet formula = 1.618^N - .618^N / sqrt(5)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());

        float c = 1.618f;
        float k = -.618f;
        float bennet = ((float) Math.pow(c, n) - (float) Math.pow(k, n)) / (float) Math.sqrt(5);

        System.out.println("Fibonnaci is " + Math.round(bennet));
    }
}
