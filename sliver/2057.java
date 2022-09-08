import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[] factorial = new long[21];
        long tmp = 1;
        factorial[0] = tmp;
        for(int i = 1; i < 21; i++){
            tmp *= i;
            factorial[i] = tmp;
        }
        int cnt = 20;
        long sum = 0;
        while(cnt >= 0){
            if(sum + factorial[cnt] == n){
                System.out.println("YES");
                return;
            }
            if(sum + factorial[cnt] < n)
                sum += factorial[cnt];
            
            cnt--;
        }
        System.out.println("NO");
    }
}