import java.io.*;

public class binarySearch2D {
    public static void main(String[] args) throws IOException {
        // rowWise();
        rowAndColumn(); // staircase way
    }

    static void rowWise() throws IOException { // when the array is sorted only for row wise
        int[][] arr = {
                { 5, 12, 19, 23 },
                { 34, 45, 56, 62 },
                { 67, 78, 89, 91 }
        };
        System.out.println("Enter the number");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        int hend = arr.length - 1;
        int lend = 0;
        int mid = 0;

        int r = -1;
        int c = -1;
        while (lend <= hend) {
            mid = lend + (hend - lend) / 2;

            if (arr[mid][0] > s)
                hend = mid - 1;

            else if (arr[mid][arr[mid].length - 1] < s)
                lend = mid + 1;

            else if (s > arr[mid][0] && s < arr[mid][arr[mid].length - 1]) {
                lend = 0;
                r = mid;
                int[] curArr = arr[mid];
                hend = curArr.length - 1;
                while (lend <= hend) {
                    mid = lend + (hend - lend) / 2;
                    if (s == curArr[mid]) {
                        c = mid;
                        break;
                    } else if (s < curArr[mid])
                        hend = mid - 1;
                    else
                        lend = mid + 1;
                }
            } else if (arr[mid][0] == s) {
                r = mid;
                c = 0;
                break;
            } else if (arr[mid][arr[mid].length - 1] == s) {
                r = mid;
                c = arr[mid].length - 1;
                break;
            }
        }
        if (r == -1 || c == -1)
            System.out.println("Element not found!");
        else
            System.out.println("Element found at index " + r + "," + c);
    }

    static void rowAndColumn() throws IOException { // staircase way of seraching in 2D
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number");
        int n = Integer.parseInt(br.readLine());
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7 },
                { 9, 10, 11, 12 },
                { 13, 14, 15 }
        };

        int r = 0;
        int decr = 1;
        int c = arr[r].length - decr;
        int index = -1;
        while (c >= 0 && r <= arr.length - 1) {
            c = arr[r].length - decr;
            System.out.println(r + " " + c);
            if (n > arr[r][c])
                r += 1;

            else if (n < arr[r][c])
                decr += 1;

            else {
                index = 1;
                break;
            }
        }
        if (index != -1)
            System.out.println("Element found at " + r + "," + c);
        else
            System.out.println("Element not found!");
    }
}
