public class nKnights {
    public static void main(String[] args) {
        char[][] arr = {
                { 'a', 'b', 'c', 'd' },
                { 'e', 'f', 'g', 'h' },
                { 'i', 'j', 'k', 'l' },
                { 'm', 'n', 'o', 'p' },
        };
        boolean[][] maze = new boolean[4][4];
        // arrange(maze, arr, "", 0); // row constraint
        arrange2(maze, arr, "", 0, 0, 4); // no constraint all combos
    }

    // static void arrange(boolean[][] maze, char[][] arr, String p, int r) { //*** */ constraint is if 1 knight is placed in a row then move to next row
    // // System.out.println(r + " row");
    // if (r >= arr.length) {
    // System.out.println("Placements are " + p);
    // return;
    // }
    // // for (int i = 0; i < 4; i++) { // excatly 4 knights placement
    // // // System.out.println(i + " col");
    // // if (!check(maze, r, i)) {
    // // maze[r][i] = !maze[r][i];
    // // arrange(maze, arr, p + arr[r][i], r + 1);
    // // maze[r][i] = !maze[r][i];
    // // }

    // }

    static void arrange2(boolean[][] maze, char[][] arr, String p, int r, int c, int knights) {
        // System.out.println(r + " row "+c+" knights "+knights); // **finds al combos no constraint like 1 knight in 1 row 
        if (r > arr.length - 1) { //*** uses subset algo pick and dont pick,and reduce knights if picked and mark it true */
            return;
        }
        if (knights == 0) {
            // System.out.println("print it");
            System.out.println(p);
            return;
        }
        if (c >= arr[0].length) {
            // System.out.println("next row");
            arrange2(maze, arr, p, r + 1, 0, knights);
            return;
        }

        if (!check(maze, r, c)) {
            maze[r][c] = !maze[r][c];
            arrange2(maze, arr, p + arr[r][c], r, c + 1, knights - 1); // for column pick the knight
            maze[r][c] = !maze[r][c];
        }
        arrange2(maze, arr, p, r, c + 1, knights); // for column dont pick

    }

    static boolean check(boolean[][] maze, int r, int c) {

        if (r <= 0 && c <= 0)
            return false;

        if (c < 2) { // right right up
            if (r != 0) {
                if (maze[r - 1][c + 2])
                    return true;
            }
        }

        if (c > 1) { // left left up
            if (r != 0) {
                if (maze[r - 1][c - 2])
                    return true;
            }
        }

        if (r > 1) { // up up right
            if (c < maze[0].length - 1) {
                if (maze[r - 2][c + 1])
                    return true;
            }

            if (c != 0) { // up up right
                if (maze[r - 2][c - 1])
                    return true;
            }
        }

        return false;

    }
}
