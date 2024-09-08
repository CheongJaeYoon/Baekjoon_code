import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int n, m, x, y, k;
    static int[][] board;
    static int[] dr = {100, 0, 0, -1, 1};
    static int[] dc = {100, 1, -1, 0, 0};
    static int[] dice = {0, 0, 0, 0 ,0, 0, 0};
    static StringBuilder sb = new StringBuilder("");
    public static void main(String[] args) throws Exception{
        n = readInt();
        m = readInt();
        x = readInt();
        y = readInt();
        k = readInt();
        board = new int[n][m];
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                board[r][c] = readInt();
            }
        }
        for(int i = 0; i < k; i++){
            move(readInt());
        }
        System.out.print(sb.toString());
    }
    public static int readInt() throws Exception{
        st.nextToken();
        return (int) st.nval;
    }
    public static void move(int dir){
        int nr = x + dr[dir];
        int nc = y + dc[dir];
        if(nr < 0 || nr >= n || nc < 0 || nc >= m) return;
        if(dir == 1){
            int tmp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = tmp;
        }
        if(dir == 2){
            int tmp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = tmp;
        }
        if(dir == 3){
            int tmp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = tmp;
        }
        if(dir == 4){
            int tmp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = tmp;
        }

        if(board[nr][nc] == 0){
            board[nr][nc] = dice[6];
        }
        else{
            dice[6] = board[nr][nc];
            board[nr][nc] = 0;
        }
        x = nr;
        y = nc;
        sb.append(dice[1] + "\n");
    }
}
