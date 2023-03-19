import java.util.*;

import javax.xml.stream.events.EndElement;

import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[][] dp = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) dp[i][j] = 0;
                else dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; i + j < n; j++){
                int start = j;
                int end = j + i;

                for(int k = start; k < end; k++){
                    int cost = dp[start][k] + dp[k+1][end] + arr[start][0] * arr[k][1] * arr[end][1];
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}