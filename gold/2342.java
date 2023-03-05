import java.io.*;
import java.util.*;

public class Main{
    public static int[][][] dp;
    public static int n;
    public static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        while(true){
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) break;
            arr.add(num);
        }

        n = arr.size();
        dp = new int[n][5][5];

        System.out.println(func(0, 0, 0));
    }

    public static int func(int cnt, int left, int right){
        if(cnt == n){
            return 0;
        }

        if(dp[cnt][left][right] != 0) return dp[cnt][left][right];
        
        int leftpoint = calPoint(left, arr.get(cnt)) + func(cnt+1, arr.get(cnt), right);
        int rightpoint = calPoint(right, arr.get(cnt)) + func(cnt+1, left, arr.get(cnt));

        return dp[cnt][left][right] = Math.min(leftpoint, rightpoint);
    }

    public static int calPoint(int from, int to){
        if(from == to) return 1;
        if(from == 0) return 2;
        if(Math.abs(from - to) == 2) return 4;
        return 3;
    }
}