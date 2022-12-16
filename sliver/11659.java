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
        long[] arr_sum = new long[n+1];
        long sum = 0;
        arr_sum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            sum += Long.parseLong(st.nextToken());
            arr_sum[i] = sum;
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            System.out.println(-arr_sum[Integer.parseInt(st.nextToken())-1] + arr_sum[Integer.parseInt(st.nextToken())]);
        }
    }


}