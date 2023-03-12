import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] app = new int[n+1][2];

        int total_c = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++){
            app[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++){
            app[i][1] = Integer.parseInt(st.nextToken());
            total_c += app[i][1];
        }
        int[][] dp = new int[n+1][total_c+1];


        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= total_c; j++){
                if(j - app[i][1] >= 0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - app[i][1]] + app[i][0]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }

        for(int i = 0; i <= total_c; i++){
            if(dp[n][i] >= m){
                System.out.println(i);
                return;
            }
        }
    }
}