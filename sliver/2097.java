import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int i = 1;
        int j = 1;
        int t = 4;
        while(true){
            if(n <= t)
                break;
            i++;
            t = (i + 1) * (j + 1);
            if(n <= t)
                break;
            j++;
            t = (i + 1) * (j + 1);
        }
        System.out.println((i + j) * 2);
    }
}