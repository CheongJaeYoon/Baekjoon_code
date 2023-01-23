import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static int n;
    public static long b;
    public static long[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());
        arr= new long[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        long[][] result;
        result = func(b);
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j]%1000);
                if(j != n - 1){
                    System.out.print(" ");
                }
            }
            if(i != n - 1){
                System.out.print("\n");
            }
        }
    }

    public static long[][] func(long num){
        if(num == 1){
            return arr;
        }
        if(num == 2){
            return mul(arr, arr);
        }
        long[][] tmp = func(num/2);

        if(num % 2 == 0){
            return mul(tmp, tmp);
        }
        else{
            return mul(mul(tmp, tmp), arr);
        }

    }

    public static long[][] mul(long[][] a1, long[][] a2){
        long[][] res = new long[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = 0;
                for(int a = 0; a < n ; a++){
                    res[i][j] += a1[i][a] * a2[a][j];
                }
                res[i][j] = res[i][j]%1000;
            }
        }
        return res;
    }
}