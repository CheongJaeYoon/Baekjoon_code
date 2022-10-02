import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    static StringBuilder sb;
    static char tmp;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String result = word;
        StringBuilder tmp;
        int strlen = word.length();
        boolean first = true;
        for(int a = 1; a < strlen; a++){
            for(int b = a + 1;b < strlen; b++){
                    tmp = new StringBuilder("");
                    tmp.append(reverse(word.substring(0, a)));
                    tmp.append(reverse(word.substring(a, b)));
                    tmp.append(reverse(word.substring(b, strlen)));
                    if(first){
                        result = tmp.toString();
                        first = false;
                    }
                    if(result.compareTo(tmp.toString()) > 0){
                        result = tmp.toString();
                    }
            }
        }
        System.out.println(result);
    }
    
    public static String reverse(String str){
        int len = str.length();
        sb = new StringBuilder(str);

        for(int i = 0; i < len/2; i++){
                tmp = str.charAt(i);
                sb.setCharAt(i, str.charAt(len-1-i));
                sb.setCharAt(len-1-i, tmp);
        }
        return sb.toString();
    }


}