import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main{

    static int n, m, r, c, d;
    static int[][] board;
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};
    static int cnt = 0;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    public static void main(String[] args) throws Exception{
        n = readInt();
        m = readInt();
        r = readInt();
        c = readInt();
        d = readInt();
        board = new int[n][m];
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < m; col++) {
                board[row][col] = readInt();
            }
        }
        while(true) {
            if(board[r][c] == 0) {
                board[r][c] = 3;
                cnt++;
            }
            else {
                boolean isClean = true;
                for(int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(board[nr][nc] == 0) {
                        isClean = false;
                        break;
                    }
                }
                if(isClean) {
                    if(!goBack()) break;
                }
                else {
                    rotateCCW();
                }
            }
        }
        System.out.print(cnt);
    }

    private static void rotateCCW() {
        switch(d) {
            case 0:
                d = 3;
                break;
            case 1:
                d = 0;
                break;
            case 2:
                d = 1;
                break;
            case 3:
                d = 2;
                break;
        }
        if(board[r + dr[d]][c + dc[d]] == 0) {
            r = r + dr[d];
            c = c + dc[d];
            board[r][c] = 3;
            cnt++;
        }


    }

    private static boolean goBack() {
        switch(d) {
            case 0:
                r = r + dr[2];
                c = c + dc[2];
                break;
            case 1:
                r = r + dr[3];
                c = c + dc[3];
                break;
            case 2:
                r = r + dr[0];
                c = c + dc[0];
                break;
            case 3:
                r = r + dr[1];
                c = c + dc[1];
                break;
        }
        if(r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }
        else if(board[r][c] == 1) {
            return false;
        }
        else return true;
    }

    public static int readInt() throws Exception{
        st.nextToken();
        return (int) st.nval;
    }
}