import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int n, k, l;
    static int[][] board;
    static char[] direction = new char[10001];
    static Deque<int[]> snack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        n = nextInt();
        k = nextInt();
        board = new int[n + 1][n + 1];
        for(int i = 0; i < k; i++){
            board[nextInt()][nextInt()] = 1;
        }
        board[1][1] = 2;
        l = nextInt();
        for(int i = 0; i < l; i++){
            direction[nextInt()] = nextChar();
        }

        int time = 0;
        int cDir = 0;
        snack.add(new int[]{1, 1});
        while(true){
            if(direction[time] != 0) cDir = nextDir(cDir, direction[time]);
            time++;

            int nr = snack.peekFirst()[0] + dr[cDir];
            int nc = snack.peekFirst()[1] + dc[cDir];
            if(nr < 1 || nc < 1 || nr > n || nc > n) break;
            if(board[nr][nc] == 2) break;
            snack.addFirst(new int[]{nr, nc});
            if(board[nr][nc] == 0){
                board[snack.peekLast()[0]][snack.peekLast()[1]] = 0;
                snack.pollLast();
            }
            board[nr][nc] = 2;
        }
        System.out.println(time);
    }

    public static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }
    public static char nextChar() throws IOException {
        st.nextToken();
        return st.sval.charAt(0);
    }
    public static int nextDir(int cDir, char command){
        if(command == 'L'){
            cDir--;
            if(cDir == -1){
                cDir = 3;
            }
        }
        else{
            cDir++;
            if(cDir == 4){
                cDir = 0;
            }
        }
        return cDir;
    }
}
