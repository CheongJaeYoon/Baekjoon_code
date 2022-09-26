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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int cnt = 0;
        int b_left = 1;
        int b_right = m;
        int cur_apple;
        for(int i = 0; i < j; i++){
            cur_apple = Integer.parseInt(br.readLine());
            while(true){
                if(cur_apple < b_left){
                    b_left--;
                    b_right--;
                    cnt++;
                }
                else if(cur_apple > b_right){
                    b_left++;
                    b_right++;
                    cnt++;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
