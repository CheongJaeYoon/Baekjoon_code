import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static final int MODULAR = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        long result = 0;
        StringTokenizer st;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            result += func(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(result%MODULAR);

    }
    public static long func(int b, int a){
        return (a*pow(b, MODULAR-2))%MODULAR;
    }
    
    public static long pow(long a, long b){
        if(b == 1){
            return a%MODULAR;
        }
        long tmp = pow(a%MODULAR, b/2);
        if(b%2 == 0){
            return (tmp*tmp)%MODULAR;
        }
        if(b%2 == 1){
            return (((tmp*tmp)%MODULAR)*a)%MODULAR;
        }
        return 0;
    }
}