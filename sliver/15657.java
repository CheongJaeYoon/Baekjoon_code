import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[] arr;
    public static int[] str_arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder("");
        arr = new int[n];
        str_arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0, 0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    public static void func(int prev, int cnt){
        if(cnt == m){
            for(int i = 0; i < m-1; i++){
                sb.append(str_arr[i] + " ");
            }
            sb.append(str_arr[m-1] + "\n");
        }
        else{
            for(int i = prev; i < n; i++){
                str_arr[cnt] = arr[i];
                func(i, cnt+1);
            }
        }
    }

}