import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt;
        int num;
        int next;
        int tmp;
        int result_cnt = 0;
        int result_next = n/2;

        for(int i = n/2; i <= n; i++){
            num = n;
            next = i;
            cnt = 0;
            while(true){
                tmp = num - next;
                num = next;
                next = tmp;
                cnt++;
                if(num < 0 )
                    break;



            }
            if(cnt > result_cnt){
                result_cnt = cnt;
                result_next = i;
            }

        }
        System.out.println(result_cnt);
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        num = result_next;
        next = n - result_next;
        while(num >= 0){
            sb.append(" " + num);
            tmp = num - next;
            num = next;
            next = tmp;
        }
        System.out.println(sb.toString());


    }


}