import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine();
        int cnt = 0;

        while(true){
            if(x.length() == 1)
                break;
            x = func2(x);
            cnt++;
        }

        System.out.println(cnt);
        if(x.equals("3") || x.equals("6") || x.equals("9")){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static String func2(String x) {
        String tmp = x;
        int sum = 0;
        for(int i = 0; i < tmp.length(); i++){
            sum += tmp.charAt(i)-'0';
        }
        return Integer.toString(sum);
    }
}