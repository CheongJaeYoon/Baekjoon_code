import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], 987654321);
            dist[i][i] = 0;
        }
        StringTokenizer st;
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a-1][b-1] = Math.min(dist[a-1][b-1], c);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                for(int k = 0; k < n; k++){
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(dist[i][j] >= 987654321){
                    System.out.print(0);
                }
                else{
                    System.out.print(dist[i][j]);
                }

                if(j != n-1){
                    System.out.print(" ");
                }
                else{
                    System.out.print("\n");
                }
            }
        }

    }
}