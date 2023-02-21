import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n == 1){
            System.out.println(0);
            return;
        }

        boolean[] isPrime = new boolean[n+1];

        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2 ; i <= n ;i++){
            if(isPrime[i] == true){
                for(int j = i * 2; j <= n; j += i){
                    isPrime[j] = false;
                }
            }

        }

        ArrayList<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= n; i++){
            if(isPrime[i] == true){
                primes.add(i);

            }
        }

        int left = 0;
        int right = 0;
        int max = primes.size();
        int sum = primes.get(left);
        int cnt = 0;

        while(left < max && right < max){
            if(n == sum){
                cnt++;
                sum -= primes.get(left);
                left++;
            }
            else if(sum < n){
                right++;
                if(right >= max) break;
                sum += primes.get(right);
            }
            else if(sum > n){
                sum -= primes.get(left);
                left++;
            }
        }

        System.out.println(cnt);
    }
}