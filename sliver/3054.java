import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int len = n.length();
        if(len == 0)
            return;
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();
        StringBuilder line3 = new StringBuilder();
        int i;
        for(i = 1; i <= len; i++){
            if(i % 3 == 0){
                line1.append("..*.");
                line2.append(".*.*");
                line3.append("*." + n.charAt(i-1) + ".");

            }
            else{
                line1.append("..#.");
                line2.append(".#.#");
                if(i > 1 && (i - 1) % 3 == 0){
                    line3.append("*." + n.charAt(i-1) + ".");
                }
                else{
                    line3.append("#." + n.charAt(i-1) + ".");
                }
            }
        }
        if((i - 1) % 3 == 0){
            line1.append(".");
            line2.append(".");
            line3.append("*");
        }
        else{
            line1.append(".");
            line2.append(".");
            line3.append("#");
        }
        System.out.println(line1.toString());
        System.out.println(line2.toString());
        System.out.println(line3.toString());
        System.out.println(line2.toString());
        System.out.println(line1.toString());
    }

}