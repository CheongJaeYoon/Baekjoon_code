import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a, b;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        System.out.println(func(b) - func(a-1));
    }
    public static long func(long num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        long tmp = 1;
        long sum = 0; // tmp 이하까지의 합
        while(true){
            tmp *= 2;
            if(tmp > num){
                sum += (num - (tmp/2 - 1)) + func(num - tmp/2);
                break;
            }
            else{
                sum += (tmp/2 + sum);
            }
        }
        return sum;
    }
}