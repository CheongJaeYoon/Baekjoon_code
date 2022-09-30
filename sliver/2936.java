import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double r_x = 0;
        double r_y = 0;

        if(x + y <= 125){
            if(x > 0){
                r_y = (250 * 250 / 2) / (250 - x);
                r_x = 250 - r_y; 
            }
            else if(y >= 0){
                r_x = (250 * 250 / 2) / (250 - y);
                r_y = 250 - r_x; 
            }
            else{
                System.out.println("error1");
            }
        }
        else if(y - x >= 0){
            if(x == 0){
                r_x = (250 * 250 / 2) / y;
                r_y = 0;
            }
            else if(x > 0){
                r_x = 250 - (250 * 250 / 2) / y;
                r_y = 0;
            }
            else{
                System.out.println("error2");
            }
        }
        else if(y - x <= 0){
            if(y > 0){
                r_y = 250 - (250 * 250 / 2) / x;
                r_x = 0;

            }
            else if(y == 0){
                r_y = (250 * 250 / 2) / x;
                r_x = 0;

            }
            else{
                System.out.println("error3");
            }
        }
        else{
            System.out.println("error4");
        }
        System.out.println(String.format("%.2f", r_x) +  " " + String.format("%.2f", r_y));
    }


}