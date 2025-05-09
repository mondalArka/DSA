public class nKnights {
    public static void main(String[] args) {
        char[][] arr = {
                { 'a', 'b', 'c', 'd' },
                { 'e', 'f', 'g', 'h' },
                { 'i', 'j', 'k', 'l' },
                { 'm', 'n', 'o', 'p' },
        };
        boolean[][] maze = new boolean[4][4];
        // arrange(maze, arr, "", 0);
        arrange2(maze, arr, "", 0, 0, 4);
    }

    // static void arrange(boolean[][] maze, char[][] arr, String p, int r) {
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
        // System.out.println(r + " row");
        if (check(maze, r, c))
            return;

        if (knights == 0) {
            System.out.println("Placements are " + p);
            return;
        }

        if (c >= arr[0].length)
            return;

        maze[r][c] = !maze[r][c];
        arrange2(maze, arr, p + arr[r][c], r, c + 1, knights - 1);
        maze[r][c] = !maze[r][c];
        arrange2(maze, arr, p + arr[r][c], r + 1, 0, knights - 1);

        for (int i = c; i < arr[0].length; i++) {
            maze[r][i] = !maze[r][i];
            p += arr[r][i];
            maze[r][i] = !maze[r][i];
            knights--;
            if (c == arr[0].length - 1)
                arrange2(maze, arr, p, r + 1, c, knights);

        }

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
