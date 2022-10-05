import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        String tmp = "";
        for(int i = 0; i < n; i++){
            tmp = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = tmp.charAt(j) == 'B' ? 1 : -1;
            }
        }
        int min = 33;
        int cnt = 0;
        int bOrW = 1;
        for(int i = 0; i <= n - 8;i++){
            for(int j = 0; j <= m - 8; j++){
                cnt = 0;
                for(int r = 0; r < 8; r++){
                    for(int c = 0; c < 8; c++){
                        if(board[i + r][j + c] == bOrW){
                            cnt++;
                        }
                        bOrW = bOrW * (-1);
                    }
                    bOrW = bOrW * (-1);
                }
                cnt = cnt > 32 ? 64 - cnt : cnt;
                min = cnt < min ? cnt : min;

            }

        }
        System.out.println(min);

    }
}