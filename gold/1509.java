import java.util.*;

import javax.xml.stream.events.EndElement;

import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        int[] dp = new int[len+1];
        boolean[][] fd  = new boolean[len+1][len+1];

        for(int start = 0; start < len; start++){
            for(int end = start; end < len; end++){
                boolean flag = true;
                int s = start;
                int e = end;
                while(s <= e){
                    if(str.charAt(s) != str.charAt(e)){
                        flag = false;
                        break;
                    }
                    s++;
                    e--;
                }
                if(flag == true){
                    fd[start+1][end+1] = true;
                }
            }
        }

        for(int i = 1; i <= len; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= i; j++){
                if(fd[j][i] == true){
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }

        System.out.println(dp[len]);
    }
}