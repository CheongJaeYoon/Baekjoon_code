import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        boolean visited[][][] = new boolean[2][n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[0][i], false);
            Arrays.fill(visited[1][i], false);
            String tmp = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = tmp.charAt(j)-'0';
            }
        }
        int[] start = new int[]{0, 0, 1, 0}; // ( x, y, cnt, flag)
        Queue<int[]> queue = new LinkedList<>();

        queue.add(start);
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == n-1 && tmp[1] == m-1){
                System.out.print(tmp[2]);
                return;
            }
            int[] dx = new int[]{ 1, -1, 0,  0};
            int[] dy = new int[]{ 0,  0, 1, -1};
            for(int i = 0; i < 4; i++){
                int x = tmp[0] + dx[i];
                int y = tmp[1] + dy[i];
                if( 0 <= x && 0 <= y && x < n && y < m){
                    if(tmp[3] == 1 && map[x][y] == 1){
                        continue;
                    }
                    else if(map[x][y] == 1 && tmp[3] == 0 && visited[1][x][y] == false){
                        visited[1][x][y] = true;
                        queue.add(new int[]{x, y, tmp[2]+1, 1});
                    }
                    else if(map[x][y] == 0 && visited[tmp[3]][x][y] == false){
                        visited[tmp[3]][x][y] = true;
                        queue.add(new int[]{x, y, tmp[2]+1, tmp[3]});
                    }
                }
            }
        }
        System.out.print(-1);
    }
}