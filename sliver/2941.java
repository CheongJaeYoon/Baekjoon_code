import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int cnt = 0;
        int len = str.length();
        char tmp = 0;

        for(int i = 0; i < len; i++){
            tmp = str.charAt(i);
            if(tmp == 'c'){
                if(i + 1 < len){
                    if(str.charAt(i+1) == '='){
                        continue;
                    }
                    else if(str.charAt(i+1) == '-'){
                        continue;
                    }
                    else{
                        cnt++;
                    }
                }
                else{
                    cnt++;
                }
            }
            else if(tmp == 'd'){
                if(i + 1 < len){
                    if(str.charAt(i+1) == 'z'){
                        if(i + 2 < len){    
                            if(str.charAt(i+2) == '='){
                                continue;
                            }
                            else{
                                cnt++;
                            }
                        }
                        else{
                            cnt++;
                        }
                    }
                    else if(str.charAt(i+1) == '-'){
                        continue;
                    }
                    else{
                        cnt++;
                    }
                }
                else{
                    cnt++;
                }
            }
            else if(tmp == 'l'){
                if(i + 1 < len){
                    if(str.charAt(i+1) == 'j'){
                        continue;
                    }
                    else{
                        cnt++;
                    }
                }
                else{
                    cnt++;
                }

            }
            else if(tmp == 'n'){
                if(i + 1 < len){
                    if(str.charAt(i+1) == 'j'){
                        continue;
                    }
                    else{
                        cnt++;
                    }
                }
                else{
                    cnt++;
                }

            }
            else if(tmp == 's'){
                if(i + 1 < len){
                    if(str.charAt(i+1) == '='){
                        continue;
                    }
                    else{
                        cnt++;
                    }
                }
                else{
                    cnt++;
                }

            }
            else if(tmp == 'z'){
                if(i + 1 < len){
                    if(str.charAt(i+1) == '='){
                        continue;
                    }
                    else{
                        cnt++;
                    }
                }
                else{
                    cnt++;
                }

            }
            else{
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}