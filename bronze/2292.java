import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int left = 0;
        int right = 1;
        int tmp;
        int i = 1;
        while(true){
            cnt++;
            if(left < n && n <= right)
                break;
            tmp = right;
            right = right + 6 * i;
            left = tmp;
            i++;
        }
        System.out.println(cnt);

    }
}