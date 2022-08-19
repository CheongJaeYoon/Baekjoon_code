import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        int cnt = 0;
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i <= n; i++){
            if(prime[i]){
                for(int j = i*2; j <=n; j += i){
                    prime[j] = false;
                }
            }
        }
        ArrayList<Integer> primeNumber = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(prime[i])
                primeNumber.add(i);
        }
        for(int i = 1; i <= n; i++){
            int max = 1;
            boolean check = false;
            for(int num : primeNumber){
                if(i < num)
                    break;
                if(i % num == 0){
                    max = num;
                }
                if(max > k){
                    check = true;
                    break;
                }
            }
            if(max == 1)
                max = i;
            if(max > k)
                check = true;
            if(check == false){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}