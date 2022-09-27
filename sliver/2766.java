import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] candy;
        int[] give_candy;
        int round_cnt;
        int candy_cnt;
        boolean tmp;
        StringBuilder result = new StringBuilder();
        boolean start = true;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            if(start == false){
                result.append("\n");
            }
            start = false;
            candy = new int[n];
            give_candy = new int[n];
            round_cnt = 0;
            candy_cnt = 0;
            for(int i = 0; i < n; i++){
                candy[i] = Integer.parseInt(br.readLine());
            }
            while(true){
                candy_cnt = candy[0];
                tmp = true;
                for(int i = 1; i < n; i++){
                    if(candy_cnt != candy[i]){
                        tmp = false;
                        break;
                    }
                }
                if(tmp == true){
                    break;
                }

                for(int i = 0; i < n; i++){
                    give_candy[i == n-1 ? 0 : i+1]  = candy[i]/2;
                    candy[i] = candy[i]/2;
                }
                for(int i = 0; i < n; i++){
                    candy[i] += give_candy[i];
                }
                for(int i = 0; i < n; i++){
                    if(candy[i] % 2 == 1){
                        candy[i]++;
                    }
                }
                round_cnt++;
            }
            result.append(round_cnt + " " + candy_cnt);
        }
        System.out.println(result.toString());
    }


}