import java.util.*;
import java.io.*;
import java.lang.Math;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(n == 1){
                System.out.println(Math.max(arr[0][0], arr[1][0]));
            }
            if(n == 2){
                System.out.println(Math.max(arr[0][0] + arr[1][1], arr[1][0] + arr[0][1]));
            }
            if(n > 2){
                int[][] dp = new int[2][n];
                dp[0][0] = arr[0][0];
                dp[1][0] = arr[1][0];
                dp[0][1] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[0][0] + arr[1][1];
                for(int i = 2; i < n; i++){
                    dp[0][i] = arr[0][i] + Math.max(dp[1][i-1] , dp[1][i-2]);
                    dp[1][i] = arr[1][i] + Math.max(dp[0][i-1] , dp[0][i-2]);
                }
                System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
            }

        }

    }
}