import java.util.*;

import javax.xml.stream.events.EndElement;

import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 1000000000;
        long[][][] dp = new long[n+1][11][1 << 10];

        for(int i = 1; i < 10; i++){
            dp[1][i][1 << i] = 1;
        }

        for(int i = 2; i < n+1; i++){ // i : 자리수
            for(int j = 0; j < 10; j++){ // j : 마지막자리 수
                for(int k = 1; k < (1 << 10); k++){
                    int bit = k | (1 << j);
                    if(j == 0){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k]) % mod;
                    }
                    else if(j == 9){
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j-1][k]) % mod;
                    }
                    else{
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i-1][j+1][k] + dp[i-1][j-1][k]) % mod;
                    }
                }
            }
        }
        long sum = 0;
        for(int i = 0; i < 10; i++){
            sum += dp[n][i][(1 << 10) - 1];
        }
        System.out.println(sum % mod);

    }
}