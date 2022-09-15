import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    static int[] arr = new int[3];
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int a = 1; a <= n/3; a++){
            for(int b = a; b <= (n - a)/2; b++){
                int c = n-a-b;
                if(c < b)
                    continue;
                if(triangle_check(a, b, c))
                    cnt++;

            }
        }
        System.out.println(cnt);


    }

    public static boolean triangle_check(int a, int b, int c){
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        if(arr[2] < arr[0] + arr[1])
            return true;
        else
            return false;
    }


}