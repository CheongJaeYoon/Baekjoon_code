import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i <= n/2; i++){
            int total = n - i;
            sum += combination(total, i);
            sum = sum % 10007;
        }
        System.out.println(sum);
    }
    public static int combination(int n, int k){
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(1);
        for(int i = n; i > n-k; i--){
            a = a.multiply(BigInteger.valueOf(i));
        }
        for(int i = 1; i <= k; i++){
            b = b.multiply(BigInteger.valueOf(i));
        }
        BigInteger c = a.divide(b);
        c = c.mod(BigInteger.valueOf(10007));
        return c.intValue();
    }
}