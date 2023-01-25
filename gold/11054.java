import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp_asc = new int[n];
        int[] dp_des = new int[n];
        int[] dp_sum = new int[n];
        dp_asc[0] = 1;
        dp_des[n-1] = 1;
        for(int i = 1; i < n; i++){
            dp_asc[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp_asc[i] <= dp_asc[j]){
                    dp_asc[i] = dp_asc[j]+1;
                }
            }
        }
        for(int i = n-2; i >= 0; i--){
            dp_des[i] = 1;
            for(int j = n-1; j >= 0; j--){
                if(arr[j] < arr[i] && dp_des[i] <= dp_des[j]){
                    dp_des[i] = dp_des[j]+1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            dp_sum[i] = dp_asc[i] + dp_des[i] - 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            if(max < dp_sum[i]){
                max = dp_sum[i];
            }
        }
        System.out.print(max);
    }
}