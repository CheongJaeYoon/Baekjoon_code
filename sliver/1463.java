import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        Arrays.fill(arr, -1);
        func(n, 0);
        System.out.println(arr[1]);
    }
    public static void func(int num, int cnt){
        if(arr[1] != -1 && cnt > arr[1]){
            return;
        }
        if(arr[num] == -1){
            arr[num] = cnt;
        }
        else if(arr[num] > cnt){
            arr[num] = cnt;
        }
        else if(arr[num] <= cnt){
            return;
        }
        if(num % 3 == 0 && num >= 3){
            func(num/3, cnt+1);
        }
        if(num % 2 == 0 && num >= 2){
            func(num/2 , cnt+1);
        }
        if(num >= 2){
            func(num-1, cnt+1);
        }
    }
}