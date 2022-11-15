import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int sum = 0;
        String[] minus = str.split("\\-");

        for(int i = 0; i < minus.length; i++){
            String[] plus = minus[i].split("\\+");
            int tmp = 0;
            for(int j = 0; j < plus.length; j++){
                tmp += Integer.parseInt(plus[j]);
            }
            if(i == 0){
                sum += tmp;
            }
            else{
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}