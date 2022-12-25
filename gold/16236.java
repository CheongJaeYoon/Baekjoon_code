import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] baby = {0, 0};
        int[][] ocean = new int[n][n];
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int cnt = 0;
        int eat = 0;
        int s_size = 2;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n;j++){
                ocean[i][j] = Integer.parseInt(st.nextToken());
                if(ocean[i][j] == 9){
                    baby = new int[]{i, j};
                    ocean[i][j] = 0;
                }
            }
        }
        while(true){
            int[][] dist = new int[n][n];
            Queue<int[]> fishes = new LinkedList<>();
            Queue<int[]> queue = new LinkedList<>();
            queue.add(baby);

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                for(int i = 0; i < 4; i++){
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if(nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == 0 && ocean[nx][ny] <= s_size){
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{nx, ny});
                        if(1 <= ocean[nx][ny] && ocean[nx][ny] <= 6 && ocean[nx][ny] < s_size){
                            fishes.add(new int[]{nx, ny, dist[nx][ny]});
                        }
                    }
                }
            }
            if(fishes.isEmpty()){
                System.out.println(cnt);
                return;
            }
            int[] fish = fishes.peek();
            while(!fishes.isEmpty()){
                int[] tmp = fishes.poll();
                if(fish[2] > tmp[2]){
                    fish = tmp;
                }
                else if(fish[2] == tmp[2]){
                    if(fish[0] > tmp[0]){
                        fish = tmp;
                    }
                    else if(fish[0] == tmp[0]){
                        if(fish[1] > tmp[1]){
                            fish = tmp;
                        }
                    }
                }
            }

            cnt += fish[2];
            eat++;
            if(eat == s_size){
                s_size++;
                eat = 0;
            }
            ocean[fish[0]][fish[1]] = 0;
            baby = new int[]{fish[0], fish[1]};
            
        }

	}
}