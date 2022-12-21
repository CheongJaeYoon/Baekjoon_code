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

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int x = 0;
        int y = 0;
        int angle = 1;
        boolean invalid = false;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(op.equals("MOVE")){
                if(angle == 1){
                    x += num;
                }
                if(angle == 2){
                    y -= num;
                }
                if(angle == 3){
                    x -= num;
                }
                if(angle == 4){
                    y += num;
                }
                if(x < 0 || x > m || y < 0 || y > m){
                    invalid = true;
                    break;
                }
            }
            if(op.equals("TURN")){
                if(num == 0){
                    angle--;
                }
                if(num == 1){
                    angle++;
                }
                if(angle == 0){
                    angle = 4;
                }
                if(angle == 5){
                    angle = 1;
                }
            }
        }
        if(invalid == true){
            System.out.println(-1);
        }
        else{
            System.out.println(x + " " + y);
        }
    }


}