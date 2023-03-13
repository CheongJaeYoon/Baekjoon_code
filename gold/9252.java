import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fir = br.readLine();
        String sec = br.readLine();
        int n = fir.length();
        int m = sec.length();
        int[][] lcs = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            lcs[i][0] = 0;
        }
        for(int i = 0; i < m+1; i++){
            lcs[0][i] = 0;
        }
        for(int i = 1; i < n+1; i++){
            for(int j =1; j < m+1; j++){
                if(fir.charAt(i-1) == sec.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[n][m]);

        StringBuilder sb = new StringBuilder("");

        while(n != 0 && m != 0){

            if(lcs[n-1][m] == lcs[n][m]){
                n--;
            }
            else if(lcs[n][m-1] == lcs[n][m]){
                m--;
            }
            else{
                
                sb.append(fir.charAt(n-1));
                n--;
                m--;
            }
        }
        sb = sb.reverse();
        System.out.println(sb.toString());
    }
}