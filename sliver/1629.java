import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static long c;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());
        System.out.println(pow(a, b));
    }

    public static long pow(long a, long b){
        if(b == 1){
            return a%c;
        }
        long tmp = pow(a%c, b/2);
        if(b%2 == 0){
            return (tmp*tmp)%c;
        }
        if(b%2 == 1){
            return (((tmp*tmp)%c)*a)%c;
        }
        return 0;
    }
}