import java.util.*;
import java.beans.Visibility;
import java.io.*;
import java.lang.Math;

public class Main{
    public static int[][] dots;
    public static int n;
    public static double min;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            // 변수 입력
            n  = Integer.parseInt(br.readLine());
            min = Double.MAX_VALUE;

            dots = new int[n][2];
            StringTokenizer st;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                dots[i][0] = Integer.parseInt(st.nextToken());
                dots[i][1] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n];

            func(0, 0);

            System.out.println(min);
        }
    }

    public static void func(int cnt, int prev) {
        if(cnt == n/2){
            vectorSum();
        }
        else{
            for(int i = prev; i < n; i++){
                if(visited[i] == false){
                    visited[i] = true;
                    func(cnt+1, i);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static void vectorSum() {
        double sum_x = 0;
        double sum_y = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == true){
                sum_x += dots[i][0];
                sum_y += dots[i][1];
            }
            else{
                sum_x -= dots[i][0];
                sum_y -= dots[i][1];
            }
        }
        min = Math.min(min, Math.sqrt(Math.pow(sum_x, 2) + Math.pow(sum_y, 2)));
    }
}