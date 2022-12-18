import java.util.*;
import java.io.*;

public class Main {
	static int n, m, max, map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(1,i,j,i,j,visited,map[i][j]);
				visited[i][j] = false;
				makeT(i,j);
			}
		}
		
		System.out.println(max);
		br.close();

	}
	
	static void makeT(int x, int y) {
		int[] t = new int[4];
		if(x+1<n && y+2<m) {
			t[0] = map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1];
		}
		if(x+2<n && y+1<m) {
			t[1] = map[x][y] + map[x+1][y] + map[x+1][y+1] + map[x+2][y];
		}
		if(x+2<n && y-1>=0) {
			t[2] = map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y-1];
		}
		if(x-1>=0 && y+2<m) {
			t[3] = map[x][y] + map[x][y+1] + map[x-1][y+1] + map[x][y+2];
		}
		int tmp_max = Integer.MIN_VALUE;
		for(int sum : t) {
			tmp_max = tmp_max < sum ? sum : tmp_max;
		}
		
		max = max < tmp_max ? tmp_max : max;
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static void dfs(int cnt,int origin_x, int origin_y, int x, int y, boolean[][] visited, int sum) {
		
		if(cnt == 4) {
			max = max < sum ? sum : max;
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
			visited[nx][ny] = true;
			dfs(cnt+1,origin_x, origin_y, nx, ny,visited,sum+map[nx][ny]);
			visited[nx][ny] = false;
			
		}
	}
}