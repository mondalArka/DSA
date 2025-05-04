import java.util.Arrays;

public class nQueens {
    public static void main(String[] args) {
        char[][] arr = {
                { 'a', 'b', 'c', 'd' },
                { 'e', 'f', 'g', 'h' },
                { 'i', 'j', 'k', 'l' },
                { 'm', 'n', 'o', 'p' },
        };
        boolean[][] maze = new boolean[4][4];
        // maze[0][2] = true;
        arrange(maze, arr, "", 0);
        // System.out.println(check(maze, 1, 0));
    }

    static void arrange(boolean[][] maze, char[][] arr, String p, int r) {
        // System.out.println(r+" ");
        // for(int i=0;i<arr.length;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         System.out.print(maze[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("----------------------------------");

        if(r==arr.length){
                System.out.println(p);
                return;
        }
        

        for(int i=0;i<arr[0].length;i++){
            if(!check(maze,r,i)){
                maze[r][i]=!maze[r][i];
                arrange(maze, arr, p+arr[r][i], r+1);
                maze[r][i]=!maze[r][i];
            }
        }

    }

    static boolean check(boolean[][] maze, int r, int c) {
        // System.out.println("xxxx");
        if (r < 0 || c < 0 || r>maze.length-1 || c>maze[0].length-1 )
            return false;

        int r1 = r;
        int c1 = c;
        while (r1 > 0) {
            if (maze[r1 - 1][c1])
                return maze[r1 - 1][c1];

            r1--;
        }

        r1 = r;
        c1 = c;

        while (c1 > 0 && c1 <= maze[0].length - 1 && r1 > 0) { // left diagonal check
            // System.out.println("left check");
            if (maze[r1 - 1][c1 - 1])
                return true;
            r1--;
            c1--;
        }

        r1 = r;
        c1 = c;
        while (c1 >= 0 && c1 < maze[0].length - 1 && r1 > 0) { // right diagonal check
            // System.out.println("right check");
            if (maze[r1 - 1][c1 + 1])
                return true;
            r1--;
            c1++;
        }
        return false;

    }
}