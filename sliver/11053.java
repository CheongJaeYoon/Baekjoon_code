import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(a[j] < a[i] && dp[i] <= dp[j]){
                    dp[i] = dp[j]+1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.print(max);
    }
}