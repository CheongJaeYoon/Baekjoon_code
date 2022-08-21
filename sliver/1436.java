import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 1;
        int cnt = 0;
        while(n != cnt){
            int tmp = num;
            while(tmp != 0){
                if(tmp % 1000 == 666){
                    cnt++;
                    break;
                }
                else{
                    tmp /= 10;
                }
            }
            num++;
        }
        System.out.println(num - 1);
    }
}