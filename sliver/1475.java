import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt[] = new int[10];
        Arrays.fill(cnt, 0);
        for(int i = 0; i < str.length(); i++){
            cnt[(int)(str.charAt(i) - '0')]++;
        }
        int tmp = (int)Math.ceil(((double)cnt[6] + (double)cnt[9])/2);
        cnt[6] = tmp;
        cnt[9] = tmp;

        int max = 0;

        for(int i = 0; i < 10; i++){
            if(cnt[max] < cnt[i])
                max = i;
        }

        System.out.println(cnt[max]);

    }
}