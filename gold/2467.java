import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static StringBuilder[] str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = n - 1;
        long sum;
        long min = Long.MAX_VALUE;
        int ml = 0, mr = 0;
        
        
        while(left < right){
            sum = arr[left] + arr[right];
            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                ml = left;
                mr = right;
            }
            
            if(sum >= 0){
                right--;
            }
            else{
                left++;
            }
        }

        System.out.println(arr[ml] + " " + arr[mr]);

    }
}