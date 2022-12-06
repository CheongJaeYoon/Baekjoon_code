import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int pat = 0;
        int cnt = 0;
        for(int i = 0; i < s; i++){
            char c = str.charAt(i);
            if(c == 'I'){
                if(pat%2 == 0){
                    pat++;
                    if(pat >= 2*n+1){
                        cnt++;
                    }
                }
                else{
                    pat = 1;
                }
            }
            else if(c == 'O'){
                if(pat%2 == 1){
                    pat++;
                }
                else{
                    pat = 0;
                }
            }
        }
        System.out.println(cnt);
    }


}