import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int max = a > b ? a : b;
        int gcf = 1;
        int gcd = max;

        for(int i = 1; i <= max; i++){
            if(a % i == 0 && b % i == 0){
                gcf = i;
            }
        }

        int tmp_a = a;
        int tmp_b = b;
        while(true){
            if(tmp_a == tmp_b){
                gcd = tmp_a;
                break;
            }

            if(tmp_a > tmp_b){
                tmp_b += b;
            }
            else{
                tmp_a += a;
            }
        }

        
        System.out.println(gcf);
        System.out.println(gcd);
    }
}