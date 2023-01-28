import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        long[][] sum = new long[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0 && j == 0){
                    sum[i][j] = arr[i][j];
                }
                else if(i == 0){
                    sum[i][j] = sum[i][j-1] + arr[i][j];
                }
                else if(j == 0){
                    sum[i][j] = sum[i-1][j] + arr[i][j];
                }
                else{
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
                }
            }
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            long res = sum[x2][y2];
            long tmp1 = 0;
            long tmp2 = 0;
            long tmp3 = 0;
            if(x1 > 0){
                tmp1 = sum[x1-1][y2];
            }
            if(y1 > 0){
                tmp2 = sum[x2][y1-1];
            }
            if(x1 > 0 && y1 > 0){
                tmp3 = sum[x1-1][y1-1];
            }
            res = res - tmp1 - tmp2 + tmp3;
            System.out.println(res);

        }
    }


}