import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static int[][] arr;
    public static int cnt_m1, cnt_0, cnt_1;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt_m1 = 0;
        cnt_0 = 0;
        cnt_1 = 0;
        func(0, 0, n, n);
        System.out.println(cnt_m1);
        System.out.println(cnt_0);
        System.out.println(cnt_1);

    }
    public static void func(int a, int b, int c, int d){
        boolean isSame = true;
        int tmp = arr[a][b];
        for(int i = a; i < c; i++){
            for(int j = b; j < d; j++){
                if(arr[i][j] != tmp){
                    isSame = false;
                    break;
                }
            }
        }
        if(isSame != true){
            tmp = c - a;
            tmp = tmp / 3;
            for(int i = a; i < c; i += tmp){
                for(int j = b; j < d; j += tmp){
                    func(i, j, i+tmp, j+tmp);
                }
            }
        }
        else{
            if(tmp == -1){
                cnt_m1++;
            }
            if(tmp == 0){
                cnt_0++;
            }
            if(tmp == 1){
                cnt_1++;
            }
        }

    }
}