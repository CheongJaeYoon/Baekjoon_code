import java.util.*;
import java.io.*;
import java.lang.Math;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for(int i = 4; i < 101; i++){
            arr[i] = arr[i-3] + arr[i-2];
        }
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[n]);
        }

    }
}