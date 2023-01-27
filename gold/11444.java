import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static long[][] matrix_a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        matrix_a= new long[2][2];
        matrix_a[0][0] = 1;
        matrix_a[0][1] = 1;
        matrix_a[1][0] = 1;
        matrix_a[1][1] = 0;

        long[][] result;
        result = func(Long.parseLong(br.readLine())-1);
        System.out.print(result[0][0]%1000000007);

    }

    public static long[][] func(long num){
        if(num == 0){
            return matrix_a;
        }
        if(num == 1){
            return matrix_a;
        }
        if(num == 2){
            return mul(matrix_a, matrix_a);
        }
        long[][] tmp = func(num/2);

        if(num % 2 == 0){
            return mul(tmp, tmp);
        }
        else{
            return mul(mul(tmp, tmp), matrix_a);
        }

    }

    public static long[][] mul(long[][] a1, long[][] a2){
        long[][] res = new long[2][2];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                res[i][j] = 0;
                for(int a = 0; a < 2 ; a++){
                    res[i][j] += a1[i][a] * a2[a][j];
                }
                res[i][j] = res[i][j]%1000000007;
            }
        }
        return res;
    }
}