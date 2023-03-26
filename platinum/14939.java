import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
	static int n = 10;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                board[i][j] = str.charAt(j);
            }
        }
        char[][] tmp = new char[n][n];

        int cnt = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < (1 << 10); i++){
            cnt = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    tmp[j][k] = board[j][k];
                }
            }

            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0){
                    pushSwitch(tmp, 0, j);
                    cnt++;
                }
            }
            for(int j = 1; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(tmp[j - 1][k] == 'O'){
                        pushSwitch(tmp, j, k);
                        cnt++;
                    }
                }
            }

            boolean flag = true;
            for(int j = 0; j < n; j++){
                if(tmp[9][j] == 'O') flag = false;
            }
            if(flag == true){
                min = Math.min(min, cnt);
            }
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(min);
        }
    }

    public static void pushSwitch(char[][] board, int x, int y){
		board[x][y] = (board[x][y] == '#'? 'O' : '#' );
		for(int d=0; d<4; d++) {
			int cx = x + dx[d];
			int cy = y + dy[d];
			
			if(cx <0 || cy <0 || cx >= n || cy >= n) continue;
			
			board[cx][cy] = (board[cx][cy] == '#'? 'O' : '#' );
		}
    }
}
