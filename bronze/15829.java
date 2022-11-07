import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long sum = 0;
        for(int i = 0; i < l; i++){
            sum += hash(str.charAt(i) -'a' + 1, i);
        }
        System.out.println(sum%1234567891);
    }

    public static long hash(int a_i, int i){
        long m = 1234567891;
        long r = 31;
        long res;
        long tmp = 1;
        for(int j = 0; j < i; j++){
            tmp *= r;
            tmp %= m;
        }
        res = (a_i*tmp)%m;
        return res;
    }
}