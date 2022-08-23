import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[] primeNum = new boolean[10001];
        Arrays.fill(primeNum, true);
        primeNum[0] = false;
        primeNum[1] = false;
        for(int i = 2; i < 10001; i++){
            if(primeNum[i] == true){
                for(int j = i*2; j < 10001; j += i){
                    primeNum[j] = false;
                }
            }
        }
        
        int sum = 0;
        int min = -1;
        for(int i = m; i <=n; i++){
            if(primeNum[i] == true){
                sum += i;
                if(min == -1)
                    min = i;
            }
        }

        if(sum != 0)
            System.out.println(sum);
        System.out.println(min);
        

    }
}