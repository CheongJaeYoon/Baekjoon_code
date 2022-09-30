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
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        double g_x = 250/3;
        double g_y = 250/3;

        if(x + y <= 250){

        }
        else if(y - x >= 0){

        }
        else if(y - x <= 0){

        }
        else{
            System.out.println("error");
        }
    }


}