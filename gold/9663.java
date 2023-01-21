import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static int n;
    public static int cnt;
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt = 0;
        arr = new int[n];
        nQueen(0);
        System.out.print(cnt);
    }

    public static void nQueen(int depth){
        if(depth == n){
            cnt++;
            return;
        }
        for(int j = 0; j < n; j++){
            boolean flag = true;
            for(int i = 0; i < depth; i++){
                if(j == arr[i]){
                    flag = false;
                    break;
                }
                if(depth - i == Math.abs(j - arr[i])){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                arr[depth] = j;
                nQueen(depth+1);
            }
        }
    }
}