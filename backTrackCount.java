public class backTrackCount {
    static int count = 0;

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(paths(arr.length, count, 0, 0) + " number of paths"); // number of paths

        printPaths(arr.length, "", 0, 0);
    }

    static int paths(int l, int cp, int r, int c) {
        if (r == l - 1 && c == l - 1)
            return cp + 1;

        if (r >= l - 1) // when it reaches the right side end then only go down
            return paths(l, cp, r, c + 1);
        else if (c >= l - 1) // when it reaches the bottom end then only go right
            return paths(l, cp, r + 1, c);

        return paths(l, cp, r, c + 1) + paths(l, cp, r + 1, c); // left one is for going right and right side is for going down
    }

    static void printPaths(int l, String p, int r, int c) {
        if (r >= l - 1 && c >= l - 1) {
            System.out.println(p+" is the path");
            return;
        }
        if (r >= l - 1) {
            printPaths(l, p, r, c + 1);
            return;
        } else if (c >= l - 1) {
            printPaths(l, p, r + 1, c);
            return;
        }

        printPaths(l, p,r + 1, c);
        printPaths(l, p, r, c + 1);
    }
}
