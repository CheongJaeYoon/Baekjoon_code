import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static int n;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        cnt = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 1, 0);

        System.out.println(cnt);

	}

	private static void bfs(int x, int y, int dir) {
        if(x == n-1 && y == n-1){
            cnt++;
            return;
        }
        if(dir == 0){ // 가로
            if( y < n - 1 && arr[x][y+1] == 0){
                bfs(x, y+1, 0);
            }
        }
        if(dir == 1){ // 세로
            if( x < n - 1 && arr[x+1][y] == 0){
                bfs(x+1, y, 1);
            }
        }
        if(dir == 2){ // 대각선
            if( y < n - 1 && arr[x][y+1] == 0){
                bfs(x, y+1, 0);
            }
            if( x < n - 1 && arr[x+1][y] == 0){
                bfs(x+1, y, 1);
            }
        }
        if( x < n - 1 && y < n - 1 && arr[x][y+1] == 0 && arr[x+1][y] == 0 && arr[x+1][y+1] == 0){
            bfs(x+1, y+1, 2);
        }
	}

}