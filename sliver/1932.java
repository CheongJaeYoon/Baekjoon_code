import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = n-1; i > 0; i--){
            for(int j = 1; j <= i; j++){
                arr[i][j] = (arr[i+1][j] > arr[i+1][j+1]) ? arr[i+1][j] + arr[i][j] : arr[i+1][j+1] + arr[i][j];
            }
        }
        System.out.println(arr[1][1]);
    }
}