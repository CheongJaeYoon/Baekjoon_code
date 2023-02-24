import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static int n;
    public static int b_cnt, w_cnt;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] dx = {-1, -1, 1, 1};
    public static int[] dy = {-1, 1, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i< n ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        b_cnt = 0;
        w_cnt = 0;
        black(0, 0, 0);
        white(1, 0, 0);
        System.out.print(b_cnt + w_cnt);
    }

    public static void black(int x, int y, int cnt){
        b_cnt = Math.max(b_cnt, cnt);

        if(x > n-1){
            y++;
            x = (y%2 == 1)? 1 : 0;
        }

        if(y > n-1) return;

        if(isAble(x, y)){
            visited[x][y] = true;
            black(x+2, y, cnt+1);
            visited[x][y] = false;
        }

        black(x+2, y, cnt);
    }

    public static void white(int x, int y, int cnt){
        w_cnt = Math.max(w_cnt, cnt);

        if(x > n-1){
            y++;
            x = (y%2 == 1)? 0 : 1;
        }
        if(y > n-1) return;

        if(isAble(x, y)){
            visited[x][y] = true;
            white(x+2, y, cnt+1);
            visited[x][y] = false;
        }

        white(x+2, y, cnt);
    }

    public static boolean isAble(int x, int y){
        if(board[x][y] == 0) return false;

        for(int i = 0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            while(xx >= 0 && xx < n && yy >= 0 && yy < n){
                if(visited[xx][yy] == true){
                    return false;
                }
                xx += dx[i];
                yy += dy[i];
            }
        }

        return true;

    }
}