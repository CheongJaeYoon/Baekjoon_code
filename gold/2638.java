import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int[][] melt = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<int[]> queue;
        int[] dx = new int[]{0, 1, -1, 0};
        int[] dy = new int[]{1, 0, 0, -1};
        int cnt = 0;
        while(true){
            //init
            for(int i = 0; i < n; i++){
                Arrays.fill(melt[i], 0);
                Arrays.fill(visited[i], false);
            }
            queue = new LinkedList<>();

            queue.add(new int[]{0, 0});
            visited[0][0] = true;


            while(!queue.isEmpty()){
                int x = queue.peek()[0];
                int y = queue.poll()[1];
                
                for(int i = 0; i < 4; i++){
                    int cx = x + dx[i];
                    int cy = y + dy[i];
                    if(cx >= 0 && cx < n && cy >= 0 && cy < m){
                        if(board[cx][cy] == 1){
                            melt[cx][cy]++;
                        }
                        else if(visited[cx][cy] == false){
                            queue.add(new int[]{cx, cy});
                            visited[cx][cy] = true;
                        }
                    }
                }
            }

            boolean flag = true;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(melt[i][j] > 1){
                        board[i][j] = 0;
                        flag = false;
                    }
                }
            }
            /*
            System.out.print("\n");
            System.out.print("\n");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.print("\n");
            }
            */

            if(flag == true){
                break;
            }

            cnt++;

        }
        System.out.println(cnt);

    }
}