import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static int n;
    public static int[][] w;
    public static int[][] dp;
    public static final int NotCycle = 11000000;
    public static final int NotVisit = 22000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1 << n];
        StringTokenizer st;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n ;i++){
            Arrays.fill(dp[i], NotVisit);
        }

        System.out.println(dfs(0, 1));
    }

    public static int dfs(int start_city, int bitmask){
        if(bitmask == ((1 << n) - 1)){
            if(w[start_city][0] == 0){
                return NotCycle;
            }
            else{
                return w[start_city][0];
            }
        }

        if(dp[start_city][bitmask] != NotVisit){
            return dp[start_city][bitmask];
        }
        
        for(int i = 0; i < n; i++){
            if(((bitmask & (1 << i)) == 0) && (w[start_city][i] != 0)){
                dp[start_city][bitmask] = Math.min(dp[start_city][bitmask], dfs(i, (bitmask | (1 << i))) + w[start_city][i]);
            }
        }

        return dp[start_city][bitmask];
    }
}