import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static int[] dp;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        dp[n] = 0;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(tmp == k)
                break;
            if(tmp != 0 && dp[tmp - 1] > dp[tmp] + 1){
                queue.add(tmp-1);
                dp[tmp - 1] = dp[tmp] + 1;
            }
            if(tmp <= 99999 && dp[tmp + 1] > dp[tmp] + 1){
                queue.add(tmp+1);
                dp[tmp + 1] = dp[tmp] + 1;
            }
            if(tmp <= 50000 && dp[tmp * 2] > dp[tmp] + 1){
                queue.add(tmp*2);
                dp[tmp * 2] = dp[tmp] + 1;
            }
        }
        System.out.println(dp[k]);
    }
}