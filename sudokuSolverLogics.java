import java.util.ArrayList;

public class sudokuSolverLogics {

    public static ArrayList<ArrayList<Integer>> filled = new ArrayList<ArrayList<Integer>>();

    static ArrayList<ArrayList<Integer>> emptyCell(int[][] board) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<ArrayList<Integer>>();
        int rs = 0;
        int re = board.length - 1;
        while (rs <= re) {
            arr = innerArrSearch(board, rs);
            if (arr.size() != 0) {
                arr.forEach(x -> newArr.add(new ArrayList<>(x)));
                arr.clear();
            }

            if (rs == re)
                break;

            arr = innerArrSearch(board, re);
            if (arr.size() != 0) {
                arr.forEach(x -> newArr.add(new ArrayList<>(x)));
                arr.clear();
            }

            rs++;
            re--;

        }

        return newArr;
    }

    static ArrayList<ArrayList<Integer>> innerArrSearch(int[][] board, int r) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<ArrayList<Integer>>();
        int s = 0;
        int e = board[r].length - 1;
        while (s <= e) {
            if (board[r][s] == 0) {
                arr.add(r);
                arr.add(s);
                newArr.add(new ArrayList<>(arr));
                arr.clear();
            }

            if (s == e)
                break;

            if (board[r][e] == 0) {
                arr.add(r);
                arr.add(e);
                newArr.add(new ArrayList<>(arr));
                arr.clear();
            }

            s++;
            e--;
        }
        return newArr;
    }

    // ******************Row & column naked singles*****************
    static ArrayList<ArrayList<Integer>> nakedSingle(int[][] board) {
        filled.clear();
        // System.out.println("naked single");
        int rs = 0;
        int re = board.length - 1;
        while (rs <= re) {
            int[] unsolvedPos = sudokuSolver.isSolved(board);

            if (unsolvedPos[0] != -1 || unsolvedPos[1] != -1) {
                nakedSingleInnerRow(board, rs);
                nakedSingleColumn(board, rs);
            } else
                break;
            if (rs == re)
                break;
            if (unsolvedPos[0] != -1 || unsolvedPos[1] != -1) {
                nakedSingleInnerRow(board, re);
                nakedSingleColumn(board, re);
            } else
                break;
            rs++;
            re--;

        }
        return filled;
    }

    static void nakedSingleInnerRow(int[][] board, int r) {
        boolean notFilled = filled.stream().anyMatch(x -> x.getFirst() == -2 && x.getLast() == -2);
        if (notFilled)
            return;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<ArrayList<Integer>>();
        int s = 0;
        int e = board[r].length - 1;
        int count = 0;
        while (s <= e) {
            if (board[r][s] == 0) {
                arr.add(r);
                arr.add(s);
                newArr.add(new ArrayList<>(arr));
                arr.clear();
            }

            if (s == e) {
                count += board[r][s];
                break;
            }

            if (board[r][e] == 0) {
                arr.add(r);
                arr.add(e);
                newArr.add(new ArrayList<>(arr));
                arr.clear();
            }
            count += board[r][s] + board[r][e];
            s++;
            e--;
        }

        if (newArr.size() == 1) {
            filled.add(new ArrayList<>(newArr.get(0)));
            if (sudokuSolver.isValid(board, (45 - count), newArr.get(0).get(0), newArr.get(0).get(1))) {
                int missing = 45 - count;
                System.out.println((newArr.size() == 1
                        && sudokuSolver.isValid(board, (45 - count), newArr.get(0).get(0), newArr.get(0).get(1)))
                        + " check Valid");
                System.out.println(missing + " missing row");
                System.out.println("placed at " + newArr.get(0).get(0) + " " + newArr.get(0).get(1));
                board[newArr.get(0).get(0)][newArr.get(0).get(1)] = missing;
                nakedSingleColumn(board, newArr.get(0).get(1));
                return;
            } else {
                System.out.println("row else"+newArr.getFirst());
                ArrayList<Integer> x = new ArrayList<>();
                x.add(-2);
                x.add(-2);
                filled.add(new ArrayList<>(x));
            }
        }
    }

    static void nakedSingleColumn(int[][] board, int c) {
        boolean notFilled = filled.stream().anyMatch(x -> x.getFirst() == -2 && x.getLast() == -2);
        if (notFilled)
            return;
        int rS = 0;
        int rE = board.length - 1;
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<ArrayList<Integer>>();
        while (rS <= rE) {

            if (board[rS][c] == 0) {
                arr.add(rS);
                arr.add(c);
                newArr.add(new ArrayList<>(arr));
                arr.clear();
            }

            if (rS == rE) {
                count += board[rS][c];
                break;
            }

            if (board[rE][c] == 0) {
                arr.add(rE);
                arr.add(c);
                newArr.add(new ArrayList<>(arr));
                arr.clear();
            }
            count += board[rS][c] + board[rE][c];
            rS++;
            rE--;

        }
        if (newArr.size() == 1) {
            filled.add(new ArrayList<>(newArr.get(0)));
            if (sudokuSolver.isValid(board, (45 - count), newArr.get(0).get(0), newArr.get(0).get(1))) {
                int missing = 45 - count;
                System.out.println(missing + " missing column");
                System.out.println("placed at " + newArr.get(0).get(0) + " " + newArr.get(0).get(1));
                board[newArr.get(0).get(0)][newArr.get(0).get(1)] = missing;
                nakedSingleInnerRow(board, newArr.get(0).get(0));
                return;
            } else {
                System.out.println("col else"+newArr.getFirst());
                ArrayList<Integer> x = new ArrayList<>();
                x.add(-2);
                x.add(-2);
                filled.add(new ArrayList<>(x));
            }
        }
    }
}
