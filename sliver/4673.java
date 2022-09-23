import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        boolean[] arr = new boolean[10001];
        Arrays.fill(arr, true);
        int tmp, sum;
        for(int i = 1; i < 10001; i++){
            sum = 0;
            tmp = i;
            sum += tmp;
            while(tmp != 0){
                sum += tmp%10;
                tmp = tmp/10;
            }
            if(sum <= 10000)
                arr[sum] = false;
        }
        for(int i = 1; i < 10001; i++){
            if(arr[i] == true)
                System.out.println(i);
        }
    }
}