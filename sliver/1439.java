import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt[] = {0, 0};
        char tmp = 0;
        for(int i = 0; i < str.length(); i++){
            if(i == 0){
                tmp = str.charAt(i);
                cnt[tmp - '0']++;
            }
            if(tmp != str.charAt(i)){
                tmp = str.charAt(i);
                cnt[tmp - '0']++;
            }
        }
        System.out.println(Math.min(cnt[0], cnt[1]));
    }
}