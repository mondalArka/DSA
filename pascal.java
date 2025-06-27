public class pascal {
    public static void main(String[] args) {
        print(1,5);
        sumOfRow(1);
    }

    static void print(int num,int n) {
        for (int i = 1; i <= n; i++) {
            int q;
            int m = num;
            while (num != 0) {
                q = num / 10;
                int r = num - q * 10;
                System.out.print(r+" ");
                num = q;
            }
            System.out.println();
            num=m*11;
        }
    }

    static void sumOfRow(int row){
        System.out.println("Sum of row "+(1<<(row))); // 2^(n-1) formula
    }
}
