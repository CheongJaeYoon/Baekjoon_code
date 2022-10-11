import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] primeNum = new boolean[1000001];
        Arrays.fill(primeNum, true);
        primeNum[0] = false;
        primeNum[1] = false;
        for(int i = 2; i < 1000001; i++){
            if(primeNum[i] == true){
                for(int j = i*2; j < 1000001; j += i){
                    primeNum[j] = false;
                }
            }
        }
        for(int i = m; i <= n; i++){
            if(primeNum[i] == true){
                System.out.println(i);
            }
        }
        

    }
}