import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int tmp = 0;
        boolean noAnswer = true;
        for(int i = 1 ; i <= 1000000; i++){
            sum = i;
            tmp = i;
            while(tmp != 0){
                sum += tmp % 10;
                tmp = tmp / 10;
            } 
            if(sum == n){
                noAnswer = false;
                System.out.println(i);
                break;
            }
        }
        if(noAnswer)
            System.out.println(0);
    }
}