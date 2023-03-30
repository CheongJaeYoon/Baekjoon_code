import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

    public static boolean[][] discovered;
    public static boolean[][] finished;
    public static char[][] graph;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];
        discovered = new boolean[n][m];
        finished = new boolean[n][m];
        cnt = 0;
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                char ch = str.charAt(j);
                if(ch == 'U') graph[i][j] = 0;
                if(ch == 'D') graph[i][j] = 1;
                if(ch == 'L') graph[i][j] = 2;
                if(ch == 'R') graph[i][j] = 3;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dfs(i, j);
            }
        }
        System.out.println(cnt);
	}

    public static void dfs(int r, int c){
        discovered[r][c] = true;

        int nr = r + dr[graph[r][c]];
        int nc = c + dc[graph[r][c]];
        if(discovered[nr][nc] == false){
            dfs(nr, nc);
        }
        else if(!finished[nr][nc]){
            cnt++;
        }
        finished[r][c] = true;

    }
}