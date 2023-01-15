import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.math.BigInteger;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(combination(n, m).toString());


    }
    public static BigInteger combination(int n, int m){
        BigInteger tmp1 = BigInteger.ONE;
        BigInteger tmp2 = BigInteger.ONE;
        for(int i = 0; i < m; i++){
            tmp1 = tmp1.multiply(new BigInteger(String.valueOf(n - i)));
            tmp2 = tmp2.multiply(new BigInteger(String.valueOf(i + 1)));
        }
        return tmp1.divide(tmp2);
    }


}