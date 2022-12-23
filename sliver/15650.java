import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static int n;
    public static int m;
    public static int[] arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder("");
        arr = new int[m];
        func(0, 0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    public static void func(int prev, int cnt){
        if(cnt == m){
            sb.append(arr[0]);
            for(int i = 1; i < m; i++){
                sb.append(" " + arr[i]);
            }
            sb.append("\n");
        }
        else{
            for(int i = prev+1; i <= n; i++){
                arr[cnt] = i;
                func(i, cnt+1);
            }
        }
    }

}