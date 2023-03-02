import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] p = new int[n+1][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }
        p[n][0] = p[0][0];
        p[n][1] = p[0][1];

        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += 1l*p[i][0]*p[i+1][1] - 1l*p[i+1][0]*p[i][1];
        }
        System.out.printf("%.1f", 1d*Math.abs(sum)/2);

    }
}