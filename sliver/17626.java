import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < 50001; i++){
            for(int j = 1; j*j < 50001-i; j++){
                dp[i+j*j] = Math.min(dp[i+j*j], dp[i]+1 );
            }
        }
        System.out.println(dp[n]);
    }
}