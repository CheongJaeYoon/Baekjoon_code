import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {

    public static int[][] fibo = new int[41][2];
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 41; i++){
            Arrays.fill(fibo[i], -1);
        }
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;


        int t = Integer.parseInt(br.readLine());
        int tmp[];
        while(t-- > 0){
            tmp = fibofunc(Integer.parseInt(br.readLine()));
            System.out.println(tmp[0] + " " + tmp[1]);
        }
    }

    public static int[] fibofunc(int n){
        int[] res = new int[2];
        if(fibo[n][0] == -1){
            fibo[n][0] = fibofunc(n-1)[0] + fibofunc(n-2)[0];
            fibo[n][1] = fibofunc(n-1)[1] + fibofunc(n-2)[1];
        }
        else{
            res[0] = fibo[n][0];
            res[1] = fibo[n][1];
            return res;
        }
        res[0] = fibo[n][0];
        res[1] = fibo[n][1];
        return res;
    }
}