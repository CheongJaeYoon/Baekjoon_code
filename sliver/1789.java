import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        int n = 0;
        long sum = 0;
        while(true){
            sum += n;
            if(s == sum){
                System.out.print(n);
                break;
            }
            if(s < sum){
                System.out.print(n-1);
                break;
            }
            n++;
        }
    }
}