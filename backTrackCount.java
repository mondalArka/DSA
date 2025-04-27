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
        // printDirection(arr.length, "", 0, 0);

        // --------------------------Diagonal------------
        // System.out.println("includee diagonal "+diagonalCount(arr.length, 0, 0, 0));
        // printDiagonalPaths(arr.length, "", 0, 0); // print diagonal including paths

        // ArrayList<ArrayList<ArrayList>> arr1 = diagonalList(arr.length, new ArrayList<>(), new ArrayList<>(), 0, 0);

        // arr1.forEach(x -> System.out.println(x));

        // -----------obstacle------------
        boolean[][] mazePath= {{true,true,true},{true,true,true},{true,true,true}};
        // printPathsObstacle(mazePath, "", 0, 0);
        // ------------ up left right down ---------
        allDirections(mazePath,"",0,0);

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
        if (r >= l) {
            return;
        } else if (c >= l) {
            return;
        }
        printDirection(l, p + "D", r + 1, c); // for downside
        printDirection(l, p + "R", r, c + 1); // for right
    }

    static int diagonalCount(int l, int cp, int r, int c) {
        if (r >= l - 1 && c >= l - 1) {
            // System.out.println();
            return cp + 1;
        }

        if (r >= l - 1) {
            return diagonalCount(l, cp, r, c + 1);

        }
        if (c >= l - 1) {
            return diagonalCount(l, cp, r + 1, c);

        }
        return diagonalCount(l, cp, r + 1, c) + // down side
                diagonalCount(l, cp, r, c + 1) + // right side
                diagonalCount(l, cp, r + 1, c + 1); // diagonal
    }

    static void printDiagonalPaths(int l, String p, int r, int c) {
        if (r >= l - 1 && c >= l - 1) {
            System.out.println(p);
            return;
        }

        if (r >= l - 1) {
            printDiagonalPaths(l, p + "R", r, c + 1);
            return;
        }
        if (c >= l - 1) {
            printDiagonalPaths(l, p + "B", r + 1, c);
            return;
        }

        printDiagonalPaths(l, p + "B", r + 1, c); // down side
        printDiagonalPaths(l, p + "R", r, c + 1); // right side
        printDiagonalPaths(l, p + "D", r + 1, c + 1); // diagonal
    }

    static ArrayList<ArrayList<ArrayList>> diagonalList(int l, ArrayList<ArrayList<ArrayList>> arr,
            ArrayList<ArrayList> newArr, int r, int c) {
        if (r >= l - 1 && c >= l - 1) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(r);
            inner.add(c);
            newArr.add(new ArrayList<>(inner));
            arr.add(new ArrayList<>(newArr));
            newArr.removeLast();
            return arr;
        }

        if (r >= l - 1) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(r);
            inner.add(c);
            newArr.add(new ArrayList<>(inner));
            diagonalList(l, arr, newArr, r, c + 1);
            newArr.removeLast();
            return arr;
        }

        if (c >= l - 1) {
            ArrayList<Integer> inner = new ArrayList<>();
            inner.add(r);
            inner.add(c);
            newArr.add(new ArrayList<>(inner));
            diagonalList(l, arr, newArr, r + 1, c);
            newArr.removeLast();
            return arr;
        }

        ArrayList<Integer> inner = new ArrayList<>();
        inner.add(r);
        inner.add(c);
        newArr.add(new ArrayList<>(inner));
        diagonalList(l, arr, newArr, r + 1, c); // down side
        diagonalList(l, arr, newArr, r, c + 1); // right side
        diagonalList(l, arr, newArr, r + 1, c + 1); // diagonal side
        newArr.removeLast();
        return arr;
    }

    static void printPathsObstacle(boolean[][] maze,String p,int r, int c){

        if(r>=maze.length-1 && c>=maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]) return;
        if(r>=maze.length-1){
            printPathsObstacle(maze, p+"R", r, c+1);
            return;
        }
        if(c>=maze[0].length-1){
            printPathsObstacle(maze, p+"D", r+1, c);
            return;
        }
        printPathsObstacle(maze,p+"D",r+1, c); // down side 
        printPathsObstacle(maze,p+"R", r, c+1); // right side
    }

    static void allDirections(boolean[][] maze,String p,int r, int c){

        if(r>=maze.length-1 && c>=maze[0].length-1){
            System.out.println(p);
            return;
        }
        // if(r<=0) return;
        // if(c<=0) return;
        if(!maze[r][c]) return;
        if(r>=maze.length-1){
            allDirections(maze, p+"R", r, c+1);
            return;
        }
        if(c>=maze[0].length-1){
            allDirections(maze, p+"D", r+1, c);
            return;
        }
        
        allDirections(maze,p+"D",r+1, c); // down side 
        allDirections(maze,p+"R", r, c+1); // right side
        allDirections(maze, p+"U", r-1, c); // up side
        allDirections(maze, p+"L", r, c-1); // left side
    }
}
