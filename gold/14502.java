import java.util.*;
import java.io.*;

public class Main {
	static int n, m, max, map[][];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};

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

        create_wall(0, 0);

        System.out.println(max);

	}
	
	static void create_wall(int w_cnt, int prev) {
        if(w_cnt == 3){
            simulation();
            return;
        }
        for(int i = prev; i < n*m; i++){
            int x = i/m;
            int y = i%m;
            if(map[x][y] == 0){
                map[x][y] = 1;
                create_wall(w_cnt+1, i);
                map[x][y] = 0;
            }
        }
	}
    
	static void simulation() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] copy_map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copy_map[i][j] = map[i][j];
                if(map[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if(copy_map[nx][ny] == 0){
                        copy_map[nx][ny] = 2;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        int safe_cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copy_map[i][j] == 0){
                    safe_cnt++;
                }
            }
        }
        max = max < safe_cnt ? safe_cnt : max;
	}
	
}