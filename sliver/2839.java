import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt_5 = n/5;
        int left = n%5;
        while(true){
            if(cnt_5 == 0 && left%3 != 0){
                System.out.println(-1);
                break;
            }
            if(left%3 == 0){
                System.out.println(cnt_5 + left/3);
                break;
            }
            cnt_5--;
            left += 5;

        }
    }
}
