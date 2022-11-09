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
        int b = Integer.parseInt(st.nextToken());
        int min = 256;
        int max = 0;
        int tmp = 0;
        int best_sec = Integer.MAX_VALUE;
        int best_floor = -1;
        Integer[][] blocks = new Integer[n][m];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                tmp = Integer.parseInt(st.nextToken());
                blocks[i][j] = tmp;
                min = tmp < min ? tmp : min;
                max = tmp > max ? tmp : max;
            }
        }
        int sec;
        int inventory;
        for(int f = min; f <= max; f++){
            tmp = 0;
            sec = 0;
            inventory = b;
            for(int i = 0; i < n; i++){
                for(int j = 0; j< m; j++){
                    tmp = f - blocks[i][j];
                    if(tmp < 0){
                        inventory -= tmp;
                        sec -= tmp*2;
                    }
                    else if(tmp > 0){
                        inventory -= tmp;
                        sec += tmp;
                    }
                }
            }
            if(inventory < 0){
                continue;
            }
            else{
                if(sec < best_sec){
                    best_sec = sec;
                    best_floor = f;
                }
                else if(sec == best_sec){
                    best_floor = f < best_floor ? best_floor : f;
                }
            }
        }
        System.out.println(best_sec + " " + best_floor);
    }
}