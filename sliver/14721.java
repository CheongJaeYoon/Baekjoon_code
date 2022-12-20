import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int an_a = -1;
        int an_b = -1;
        int[][] dataset = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            dataset[i][0] = Integer.parseInt(st.nextToken());
            dataset[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int a = 1; a <= 100; a++){
            for(int b = 1; b <= 100; b++){
                int rss = 0;
                for(int i = 0; i < n; i++){
                    rss += Math.pow((dataset[i][1] - (a * dataset[i][0] + b)), 2);
                }
                if(rss < min){
                    min = rss;
                    an_a = a;
                    an_b = b;
                }
            }
        }
        System.out.println(an_a + " " + an_b);
    }
}