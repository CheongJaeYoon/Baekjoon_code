import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input_first = br.readLine().split(" ");
        int n = Integer.parseInt(input_first[0]);
        int m = Integer.parseInt(input_first[1]);
        if(n == 0){
            System.out.println(0);
            return; 
        }
        String[] input_second = br.readLine().split(" ");
        int book[] = new int[n];
        for(int i = 0; i < n; i++){
            book[i] = Integer.parseInt(input_second[i]);
        }
        int cnt = 0;
        int index = 0;
        while(true){
            if(index == n)
                break;
            int sum = 0;
            while(true){
                sum += book[index];
                if(sum > m)
                    break;
                index++;
                if(index == n)
                    break;

            }
            cnt++;
        }
        System.out.println(cnt);
    }
}