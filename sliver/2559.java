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
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        long max;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        max = sum;
        for(int i = k; i < n;i++){
            sum -= arr[i-k];
            sum += arr[i];
            if(max < sum){
                max = sum;
            }
        }
        System.out.println(max);
    }
}