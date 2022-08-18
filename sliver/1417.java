import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] vote_num = new int[n];
        for(int i = 0; i < n; i++){
            vote_num[i] = Integer.parseInt(br.readLine());
        }
        int max_num = 0;
        int cnt = 0;
        while(true){
            max_num = 0;
            for(int i = 0; i < n; i++){
                if(vote_num[max_num] <= vote_num[i]){
                    max_num = i;
                }
            }
            if(max_num == 0){
                break;
            }
            else{
                vote_num[0]++;
                vote_num[max_num]--;
                cnt++;
            }

        }
        System.out.println(cnt);
    }
}