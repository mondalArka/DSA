import java.util.ArrayList;

public class backTrackCount {
    static int count = 0;

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // System.out.println(paths(arr.length, count, 0, 0) + " number of paths"); //
        // number of paths

        // printPaths(arr.length, "", 0, 0);

        // System.out.println("the paths are ");
        // ArrayList<ArrayList<ArrayList<Integer>>> path = printPaths(arr.length, new
        // ArrayList<>(), new ArrayList<>(), 0,
        // 0);

        // path.forEach(x -> System.out.println(x));
        // -----------------------------------------------------------

        // print Directions
        printDirection(arr.length, "", 0, 0);
    }

    static int paths(int l, int cp, int r, int c) {
        if (r == l - 1 && c == l - 1)
            return cp + 1;

        if (r >= l - 1) // when it reaches the right side end then only go down
            return paths(l, cp, r, c + 1);
        else if (c >= l - 1) // when it reaches the bottom end then only go right
            return paths(l, cp, r + 1, c);

        return paths(l, cp, r, c + 1) + paths(l, cp, r + 1, c); // left one is for going right and right side is for
                                                                // going down
    }

    static ArrayList<ArrayList<ArrayList<Integer>>> printPaths(int l, ArrayList<ArrayList<ArrayList<Integer>>> arr,
            ArrayList<ArrayList> newArr, int r, int c) {
        if (r >= l - 1 && c >= l - 1) {
            // System.out.println(p+" is the path");
            ArrayList<Integer> innerArr = new ArrayList<>();
            innerArr.add(r);
            innerArr.add(c);
            newArr.add(new ArrayList(innerArr));
            arr.add(new ArrayList(newArr));
            newArr.remove(newArr.size() - 1);
            return arr;
        }
        if (r >= l) {
            return arr;
        } else if (c >= l) {
            return arr;
        }
        ArrayList<Integer> innerArr = new ArrayList<>();
        innerArr.add(r);
        innerArr.add(c);
        newArr.add(new ArrayList(innerArr));
        printPaths(l, arr, newArr, r + 1, c);
        printPaths(l, arr, newArr, r, c + 1);
        newArr.remove(newArr.size() - 1);
        return arr;
    }

    static void printDirection(int l, String p, int r, int c) {
        if (r >= l - 1 && c >= l - 1) {
            System.out.println(p);
            return;
        }
        if (r >= l - 1) {
            printDirection(l, p + "R", r, c + 1);
            return;
        } else if (c >= l - 1) {
            printDirection(l, p + "D", r + 1, c);
            return;
        }
        printDirection(l, p + "D", r + 1, c); // for downside
        printDirection(l, p + "R", r, c + 1); // for right
    }

    static void diagonalCount(int l , int cp,int r, int c){
        
    }
}
