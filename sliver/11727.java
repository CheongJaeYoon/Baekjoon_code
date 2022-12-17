import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + 2*dp[i-2];
            dp[i] = dp[i]%10007;
        }
        System.out.println(dp[n]%10007);
    }
}