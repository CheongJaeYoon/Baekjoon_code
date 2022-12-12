import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;
import java.util.concurrent.Flow.Subscriber;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < n; j++){
                if(tmp[j].equals("R")){
                    arr[i][j] = 1;
                }
                if(tmp[j].equals("G")){
                    arr[i][j] = 2;
                }
                if(tmp[j].equals("B")){
                    arr[i][j] = 3;
                }
            }
            Arrays.fill(visited[i], false);
        }
        int t = 2;
        while(t-- > 0){
            int cnt = 0;
            
            Queue<int[]> queue = new LinkedList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(visited[i][j] == false){
                        int color = arr[i][j];
                        visited[i][j] = true;
                        queue.add(new int[]{i, j});
                        while(!queue.isEmpty()){
                            int[] tmp = queue.poll();
                            int a = tmp[0];
                            int b = tmp[1];
                            if(a>0 && visited[a-1][b] == false && arr[a-1][b] == color){
                                visited[a-1][b] = true;
                                queue.add(new int[]{a-1, b});
                            }
                            if(a<n-1 && visited[a+1][b] == false && arr[a+1][b] == color){
                                visited[a+1][b] = true;
                                queue.add(new int[]{a+1, b});
                            }
                            if(b>0 && visited[a][b-1] == false && arr[a][b-1] == color){
                                visited[a][b-1] = true;
                                queue.add(new int[]{a, b-1});
                            }
                            if(b<n-1 && visited[a][b+1] == false && arr[a][b+1] == color){
                                visited[a][b+1] = true;
                                queue.add(new int[]{a, b+1});
                            }
                        }
                        
                        cnt++;
                    }
                }
            }

            System.out.print(cnt);

            for(int i = 0; i < n; i++){
                for(int j =0 ; j < n; j++){
                    if(arr[i][j] == 2){
                        arr[i][j] = 1;
                    }
                }
                Arrays.fill(visited[i], false);
            }
            if(t == 1){
                System.out.print(" ");
            }
        }


    }
}