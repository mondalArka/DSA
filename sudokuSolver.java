import java.util.ArrayList;
import java.util.Arrays;;

public class sudokuSolver {
    public static void main(String[] args) {

        // int[][] board = {
        // { 5, 3, 4, 6, 7, 8, 9, 1, 0 },
        // { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
        // { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
        // { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
        // { 4, 2, 6, 8, 0, 3, 7, 9, 1 }, // Empty cell at [4][4]
        // { 0, 1, 3, 9, 2, 4, 8, 5, 6 },
        // { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
        // { 2, 8, 7, 4, 1, 9, 0, 3, 5 }, // Empty cell at [7][6]
        // { 3, 4, 0, 2, 8, 6, 1, 7, 9 } };
        // int[][] board = {
        // { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
        // { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
        // { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
        // { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
        // { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
        // { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
        // { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
        // { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
        // { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        // };

        // int[][] board = {
        // { 5, 3, 4, 0, 7, 8, 9, 0, 2 }, // solved solution
        // { 6, 7, 2, 0, 9, 5, 3, 0, 8 },
        // { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
        // { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
        // { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
        // { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
        // { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
        // { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
        // { 3, 4, 5, 2, 8, 6, 1, 7, 9 }
        // };

        // int[][] board = {
        // { 0, 0, 0, 2, 6, 0, 7, 0, 1 }, // to solve
        // { 6, 8, 0, 0, 7, 0, 0, 9, 0 },
        // { 1, 9, 0, 0, 0, 4, 5, 0, 0 },
        // { 8, 2, 0, 1, 0, 0, 0, 4, 0 },
        // { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
        // { 0, 5, 0, 0, 0, 3, 0, 2, 8 },
        // { 0, 0, 9, 3, 0, 0, 0, 7, 4 },
        // { 0, 4, 0, 0, 5, 0, 0, 3, 6 },
        // { 7, 0, 3, 0, 1, 8, 0, 0, 0 }
        // };

        // int[][] board = {
        // { 5, 3, 0, 0, 7, 8, 9, 1, 0 }, // use brute and singles
        // { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
        // { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
        // { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
        // { 4, 2, 6, 8, 0, 3, 7, 9, 1 },
        // { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
        // { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
        // { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
        // { 3, 4, 0, 2, 8, 6, 1, 7, 0 }
        // };

        // int[][] board = {
        // { 0, 0, 0, 0, 0, 0, 0, 1, 2 }, // hardest uses singles hidden Xs and swords
        // { 0, 0, 0, 0, 3, 5, 0, 0, 0 },
        // { 0, 0, 0, 6, 0, 0, 0, 7, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 8 },
        // { 0, 0, 0, 0, 7, 0, 0, 0, 0 },
        // { 9, 0, 0, 0, 0, 0, 0, 0, 0 },
        // { 0, 8, 0, 0, 0, 4, 0, 0, 0 },
        // { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
        // { 1, 7, 0, 0, 0, 0, 0, 0, 0 }
        // };

        // int[][] board = {
        // { 5, 0 ,4, 6, 2, 0 }, // [0][5] = 1 (Row 0 naked single, after [2][5])
        // { 6, 2, 1, 0, 4, 3 },
        // { 1, 4, 3, 2, 6, 0 }, // [2][5] = 5 (Row 2 naked single)
        // { 2, 0, 5, 3, 1, 4 },
        // { 4, 5, 2, 0, 3, 6 },
        // { 3, 1, 6, 4, 5, 2 }
        // };

        // int[][] board = {
        // { 1, 0, 0, 0, 0, 7, 0, 9, 0 }, // AI Escargot hardest ever
        // { 0, 3, 0, 0, 2, 0, 0, 0, 8 },
        // { 0, 0, 9, 6, 0, 0, 5, 0, 0 },
        // { 0, 0, 5, 3, 0, 0, 9, 0, 0 },
        // { 0, 1, 0, 0, 8, 0, 0, 0, 2 },
        // { 6, 0, 0, 0, 0, 4, 0, 0, 0 },
        // { 3, 0, 0, 0, 0, 0, 0, 1, 0 },
        // { 0, 4, 1, 0, 0, 0, 0, 0, 7 },
        // { 0, 0, 7, 0, 0, 0, 3, 0, 0 }
        // };

        // int[][] board = {
        // { 1, 0, 0, 0, 0, 7, 0, 9, 0 }, // medium
        // { 0, 3, 0, 0, 2, 0, 0, 0, 8 },
        // { 0, 0, 9, 6, 0, 0, 5, 0, 0 },
        // { 0, 0, 5, 3, 0, 0, 9, 0, 0 },
        // { 0, 1, 0, 0, 8, 0, 0, 0, 2 },
        // { 6, 0, 0, 0, 0, 4, 0, 0, 0 },
        // { 3, 0, 0, 0, 0, 0, 0, 1, 0 },
        // { 0, 4, 1, 0, 0, 0, 0, 0, 7 },
        // { 0, 0, 7, 0, 0, 0, 3, 0, 0 }
        // };

        // int[][] board = {
        //         { 1, 0, 0, 0, 0, 7, 0, 9, 0 },
        //         { 0, 3, 0, 0, 2, 0, 0, 0, 8 },
        //         { 0, 0, 9, 6, 0, 0, 5, 0, 0 }, // medium escargot
        //         { 8, 0, 5, 3, 0, 0, 9, 0, 0 },
        //         { 0, 1, 0, 0, 8, 0, 0, 0, 2 },
        //         { 6, 0, 0, 0, 0, 4, 0, 0, 0 },
        //         { 3, 0, 0, 0, 0, 0, 0, 1, 0 },
        //         { 0, 4, 1, 0, 0, 0, 0, 0, 7 },
        //         { 0, 0, 7, 0, 0, 0, 3, 0, 0 }
        // };

//         int[][] board = {
//     { 1, 6, 2, 0, 5, 7, 0, 9, 0 }, // to solve grok
//     { 5, 3, 4, 0, 2, 0, 6, 0, 8 },
//     { 7, 8, 9, 6, 0, 0, 5, 0, 1 },
//     { 8, 5, 5, 3, 0, 0, 9, 0, 2 },
//     { 4, 1, 3, 0, 8, 0, 0, 0, 2 },
//     { 6, 2, 0, 0, 0, 4, 0, 0, 8 },
//     { 3, 7, 0, 0, 0, 0, 0, 1, 9 },
//     { 9, 4, 1, 0, 0, 0, 0, 0, 7 },
//     { 2, 9, 7, 0, 0, 0, 3, 0, 0 }
// };

// int[][] board = {
//     { 0, 0, 0, 0, 0, 0, 2, 0, 0 },
//     { 0, 8, 0, 3, 0, 5, 4, 0, 0 },
//     { 0, 0, 1, 0, 9, 0, 0, 0, 7 }, // to solve grok
//     { 0, 5, 0, 0, 8, 0, 0, 0, 0 },
//     { 0, 0, 4, 6, 0, 2, 9, 0, 0 },
//     { 0, 0, 0, 0, 3, 0, 0, 4, 0 },
//     { 9, 0, 0, 0, 1, 0, 6, 0, 0 },
//     { 0, 0, 7, 4, 0, 9, 0, 2, 0 },
//     { 0, 0, 6, 0, 0, 0, 0, 0, 0 }
// };

int[][] board = {
    { 0, 1, 9, 3, 0, 6, 8, 0, 5 },
    { 0, 0, 0, 0, 8, 2, 0, 0, 0 },
    { 0, 0, 0, 0, 0, 0, 4, 9, 0 },
    { 0, 3, 4, 0, 0, 0, 1, 0, 0 },
    { 1, 0, 5, 0, 0, 0, 0, 0, 0 },
    { 0, 9, 0, 4, 3, 0, 0, 6, 0 },
    { 3, 6, 1, 0, 5, 0, 0, 0, 0 },
    { 0, 0, 0, 0, 1, 0, 3, 0, 0 },
    { 4, 0, 0, 2, 0, 0, 0, 0, 9 }
};

        // int[][] board = {
        // { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
        // { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
        // { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
        // { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
        // { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
        // { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
        // { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
        // { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
        // { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        // };

        // long start = System.nanoTime();
        // int[] result = isSolved(board);
        // long end = System.nanoTime();
        // System.out.println("time " + (end - start));
        // System.out.println(Arrays.toString(isSolved(board)));

        // System.out.println("is valid " + isValid(board, 1, 2, 6));

        solver(board, 0, 0);
        // ArrayList<ArrayList<Integer>> emptyCell =
        // sudokuSolverLogics.emptyCell(board);
        // emptyCell.forEach(x->System.out.println(x));

        System.out.println(formatAsJavaArray(board) + " final");
    }

    static boolean solver(int[][] board, int r, int c) {
        // System.out.println(formatAsJavaArray(board) + " each");
        System.out.println("in recursion");
        int[] unsolvedPos = isSolved(board);
        r = unsolvedPos[0]; // find unsolved pos
        c = unsolvedPos[1];
        // System.out.println(r + " " + c+" unsolved");
        if (r == -1 && c == -1) { // if solved, print it
            System.out.println("Solved" + formatAsJavaArray(board)); // if found instantly print it, can also be printed
                                                                     // in main function
            return true;
        }
        // naked single method
        ArrayList<ArrayList<Integer>> filled = new ArrayList<>();
        ArrayList<ArrayList<Integer>> newfilled = new ArrayList<>();
        do {
            System.out.println("again");
            filled = sudokuSolverLogics.nakedSingle(board);
            filled.forEach(x -> System.out.println("filedd pos " + x));
            boolean notFilled = filled.stream().anyMatch(x -> x.getFirst() == -2 && x.getLast() == -2);
            System.out.println(notFilled + "uuuuu");
            if (notFilled == true) {
                filled.forEach(x -> {
                    if (x.getFirst() != -2 && x.getLast() != -2)
                        board[x.getFirst()][x.getLast()] = 0;
                });
                return false;
            }

            filled.forEach(x -> {
                newfilled.add(new ArrayList<>(x));
            });

        } while (!filled.isEmpty());
        // boolean nakedAllplaced = true;
        // nakedAllplaced = !newfilled.stream().anyMatch(x ->
        // board[x.getFirst()][x.getLast()] == 0); // if filled array is
        // found with any pos
        // where the value is
        // 0 then undo all
        // and return
        // newfilled.forEach(x->{ //
        // if(board[x.getFirst()][x.getLast()]==0)
        // nakedAllplaced=false;
        // });

        // if (nakedAllplaced == false) {// undo all nakeds and return
        // newfilled.forEach(x -> {
        // board[x.getFirst()][x.getLast()] = 0;
        // });
        // return false;
        // }

        // newfilled.forEach(x -> {
        // System.out.println(x + " filled log after naked");
        // });
        System.out.println(formatAsJavaArray(board) + " after naked op");
        // not solved case
        int[] bruteUnsolvedPos = isSolved(board);
        // System.out.println(Arrays.toString(bruteUnsolvedPos)+" poss");
        if (bruteUnsolvedPos[0] == -1 && bruteUnsolvedPos[1] == -1) {
            System.out.println(formatAsJavaArray(board) + " solved  by nakeds");
            return true;
        }

        r = bruteUnsolvedPos[0]; // find unsolved pos for brute force
        c = bruteUnsolvedPos[1]; // find unsolved pos for brute force
        System.out.println("brute solve " + r + " " + c);
        for (int i = 1; i <= 9; i++) {
            if (isValid(board, i, r, c)) {
                board[r][c] = i; // place the value if placeble
                System.out.println("solve with " + i);
                System.out.println(formatAsJavaArray(board) + " after brute valid");
                boolean status = solver(board, r, c); // call for the next unsolved pos
                if (status) { // if true means solution have been found end the loop process and return
                    return status;
                }
                board[r][c] = 0;
                // System.out.println(formatAsJavaArray(board) + " after brute failed");
            }
        }
        // System.out.println(filled.isEmpty() + " empty");
        // newfilled.forEach(x -> System.out.println(x + " filled log before back track"));

        newfilled.forEach(x -> {
            // System.out.println(x.get(0) + " " + x.get(1)); // back track for naked
            // singles
            board[x.get(0)][x.get(1)] = 0;
        });

        // System.out.println(formatAsJavaArray(board) + " after back track naked");

        return false;
    }

    static boolean isValid(int[][] board, int search, int r, int c) { // enter the number to to check for and the row
                                                                      // and column to check for also the box by default
                                                                      // rteurn true

        if (search < 1 || search > 9)
            return false;
        // row check
        // System.out.println("row check");
        int rowS = 0;
        int rowE = board[0].length - 1;
        int count = 0;
        while (rowS <= rowE) { // for a row checking whether a number is appearing two times or not.
            if (board[r][rowS] == search)
                count++;

            if (rowS == rowE)
                break;

            if (board[r][rowE] == search)
                count++;

            rowS++;
            rowE--;
        }
        if (count > 0) // 1 counter will be by default as a number has to appear once not twice
            return false;

        // ------------------------------------

        // column check
        // System.out.println("col check");
        count = 0;
        int colS = 0;
        int colE = board.length - 1;
        while (colS <= colE) { // for a col checking whether a number is appearing two times or not.
            if (board[colS][c] == search)
                count++;

            if (colS == colE)
                break;

            if (board[colE][c] == search)
                count++;

            colS++;
            colE--;
        }
        if (count > 0) // 1 counter will be by default as a number has to appear once not twice
            return false;

        // ---------------------------
        // box check
        // System.out.println("grid check");
        count = 0;
        int rSL = 0; // row start limit
        int rEL = board.length - 1; // row end limit
        int colSL = 0;
        int colEL = board[0].length - 1;

        // find the box row
        if (r >= 0 && r < 3) { // for top left 3 by 3 boxes
            rSL = 0;
            rEL = 2;
        } else if (r > 2 && r < 6) { // middle boxes
            rSL = 3;
            rEL = 5;
        } else if (r > 5 && r < board.length) { // bottom boxes
            rSL = 6;
            rEL = 8;
        }

        // find the box col
        if (c >= 0 && c < 3) { // for top left 3 by 3 boxes
            colSL = 0;
            colEL = 2;
        } else if (c > 2 && c < 6) { // middle boxes
            colSL = 3;
            colEL = 5;
        } else if (c > 5 && c < board.length) { // right most boxes
            colSL = 6;
            colEL = 8;
        }
        // System.out.println("the grid to check "+rSL+ " "+rEL+ " col "+colSL+"
        // "+colEL);
        for (int i = rSL; i <= rEL; i++) { // to find if search appears twice in the box
            for (int j = colSL; j <= colEL; j++) {
                if (board[i][j] == search)
                    count++;
            }
        }
        if (count > 0)
            return false;

        return true;

    }

    static int[] isSolved(int[][] board) { // 25 times loop running at worst case -two pointer search both, faster than
                                           // one loop and 2 pointer, by default returns [-1,-1] means solved
        int[] arr = { -1, -1 };
        int rs = 0;
        int re = board.length - 1;
        while (rs <= re) {
            arr = innerArrSearch(board, rs);
            if (arr[0] != -1 || arr[1] != -1)
                return arr;

            arr = innerArrSearch(board, re);
            if (arr[0] != -1 || arr[1] != -1)
                return arr;

            rs++;
            re--;

        }

        return arr;
    }

    static int[] innerArrSearch(int[][] board, int r) {
        int[] arr = { -1, -1 };
        int s = 0;
        int e = board[r].length - 1;
        while (s <= e) {
            if (board[r][s] == 0) {
                arr[0] = r;
                arr[1] = s;
                return arr;
            }

            if (board[r][e] == 0) {
                arr[0] = r;
                arr[1] = e;
                return arr;
            }

            s++;
            e--;
        }
        return arr;
    }

    static String formatAsJavaArray(int[][] board) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (int i = 0; i < board.length; i++) {
            sb.append("    { ");
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
                if (j < board[i].length - 1)
                    sb.append(", ");
            }
            sb.append(" }");
            if (i < board.length - 1)
                sb.append(",");
            sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }

    // using divide and conquer search
    // static boolean checkInnerCols(int[][] board, int r, int s, int e) { // if 0
    // found then false else
    // System.out.println(s + " s " + e + " mid " + (s + (e - s) / 2));
    // if (e <= s) {
    // if (board[r][e] == 0 || board[r][s] == 0)
    // return false;
    // else
    // return true;
    // }
    // int mid = s + (e - s) / 2;

    // if (board[r][mid] == 0)
    // return false;

    // boolean left = checkInnerCols(board, r, s, mid - 1);
    // boolean right = checkInnerCols(board, r, mid + 1, e);

    // if (left == false || right == false)
    // return false;
    // else
    // return true;

    // }
}
