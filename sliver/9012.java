import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String tmp;
        int cnt;
        while(t-- > 0){
            tmp = br.readLine();
            cnt = 0;
            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == '('){
                    cnt++;
                }
                if(tmp.charAt(i) == ')'){
                    cnt--;
                }
                if(cnt < 0){
                    break;
                }
            }
            if(cnt == 0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

}