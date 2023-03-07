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
        Arrays.sort(arr);
        int[] res = new int[3];
        long min = Long.MAX_VALUE;
        for(int i = 0; i < n-2; i++){
            int tmp = i;
            
            int left = i+1;
            int right = n - 1;
            long sum;
            
            
            while(left < right){
                sum = arr[left] + arr[right] + arr[tmp];
                if(min > Math.abs(sum)){
                    min = Math.abs(sum);
                    res[0] = tmp;
                    res[1] = left;
                    res[2] = right;
                }
                
                if(sum >= 0){
                    right--;
                }
                else{
                    left++;
                }
            }
            
        }
        Arrays.sort(res);
        System.out.println(arr[res[0]] + " " + arr[res[1]] + " " + arr[res[2]]);

    }
}