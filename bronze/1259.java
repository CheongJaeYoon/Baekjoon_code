import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder num;
        while(true){
            num = new StringBuilder(br.readLine());
            if(Integer.parseInt(num.toString()) == 0 && num.length() == 1)
                break;
            if(num.toString().charAt(0) == '0'){
                System.out.println("no");
                continue;
            }
            if(num.toString().equals(num.reverse().toString())){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }
}