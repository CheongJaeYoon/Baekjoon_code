import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1){        
            System.out.println(1);
            return;
        }

        int tmp;
        int x;
        int cnt = 0;
        for(int i = 1; i < n; i++){
            tmp = (i-1)*i/2;
            if(tmp >= n)
                break;
            if((n - tmp)%i == 0)
                cnt++;
        }
        System.out.println(cnt);
    }
}