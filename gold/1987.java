import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static int r, c, max;
    public static int[][] board;
    public static boolean[] visited;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        board = new int[r][c];
        for(int i = 0; i < r; i++){
            String tmp = br.readLine();
            for(int j = 0; j < c; j++){
                board[i][j] = tmp.charAt(j)-'A';
            }
        }
        visited = new boolean[26];
        visited[board[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt){
        //System.out.println("( " + x + ", " + y + " ), alphabet : " + (char)(board[x][y] + 'A') + " , cnt : " + cnt);
        max = Math.max(cnt, max);
        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx >= 0 &&  xx < r && yy >= 0 && yy < c){
                if(visited[board[xx][yy]] == false){
                    visited[board[xx][yy]] = true;
                    dfs(xx, yy, cnt+1);
                    visited[board[xx][yy]] = false;
                }
            }
        }

    }
}