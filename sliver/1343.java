import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        String str = br.readLine();
        String result = "";
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '.'){
                if(cnt == 0){
                    result += '.';
                }
                else if(cnt == 2){
                    result += "BB.";
                    cnt = 0;
                }
                else if(cnt == 4){
                    result += "AAAA.";
                    cnt = 0;
                }
                else{
                    System.out.println(-1);
                    return;
                }
            }
            else{
                cnt++;
                if(cnt == 4){
                    cnt = 0;
                    result += "AAAA";
                }
            }
        }
        if(cnt == 2){
            result += "BB";
        }
        else if(cnt == 4){
            result += "AAAA";
        }
        else if(cnt != 0){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
}