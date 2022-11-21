import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < n; j++){
                if(tmp[j].equals("1")){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = 0;
                }
            }
        }
        func(0, 0, n);
    }
    public static void func(int a, int b, int n){
        
        if(n == 1){
            if(arr[a][b] == 1){
                System.out.print(1);
            }
            else{
                System.out.print(0);
            }
        }
        else{
            int i, j;
            int tmp;
            tmp = arr[a][b];
            boolean isSame = true;
            for(i = a; i < a + n; i++){
                for(j = b; j < b + n; j++){
                    if(tmp != arr[i][j]){
                        isSame = false;
                        break;
                    }
                }
                if(isSame == false)
                    break;
            }
            if(isSame){
                System.out.print(tmp);
            }
            else{
                System.out.print("(");
                int x, y;
                for(x = 0; x < 2; x++){
                    for(y = 0; y < 2; y++){
                        isSame = true;
                        tmp = arr[a + x*n/2][b + y*n/2];
                        for(i = a + x*n/2; i < a + (x+1)*n/2; i++){
                            for(j = b + y*n/2; j < b + (y+1)*n/2; j++){
                                if(tmp != arr[i][j]){
                                    isSame = false;
                                    break;
                                }
                            }
                            if(isSame == false)
                                break;
                        }
                        if(isSame){
                            System.out.print(tmp);
                        }
                        else{
                            func(a + x*n/2, b + y*n/2, n/2);
                        }
                    }
                }
                System.out.print(")");
            }
                
        }
    }
}