import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int k , n;
        while(t-- > 0){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            System.out.println(func(k, n));
        }
    }

    public static int func(int floor, int arc){
        if(floor == 0)
            return arc;
        int sum = 0;
        for(int i = 1; i <= arc; i++){
            sum += func(floor-1, i);
        }
        return sum;
    }
}