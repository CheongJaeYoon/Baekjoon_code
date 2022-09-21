import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n - 1; i++){
            result.append(arr[i] + "\n");
        }
        result.append(arr[n-1]);
        System.out.print(result.toString());
    }


}