import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[10001];
        StringBuilder sb = new StringBuilder();
        Arrays.fill(arr, 0);
        for(int i = 0; i < n; i++){
            arr[Integer.parseInt(br.readLine())]++;
        }
        for(int i = 0; i < 10001; i++){
            if(arr[i] != 0){
                for(int j = 0; j < arr[i]; j++){
                    sb.append(i + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}