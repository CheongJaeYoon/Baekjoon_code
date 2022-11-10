import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static int[][] farm = new int[52][52];
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int m, n, k;
        int x, y;
        int cnt;
        while(t-- > 0){
            for(int i = 0; i < 52; i++){
                Arrays.fill(farm[i], 0);
            }
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken())+1;
                y = Integer.parseInt(st.nextToken())+1;
                farm[x][y] = 1;
            }
            cnt = check();
            System.out.println(cnt);

        }
    }

    public static int check(){
        int cnt = 0;
        for(int i = 1; i < 51; i++){
            for(int j = 1; j < 51; j++){
                if(farm[i][j] == 1){
                    visited(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void visited(int x, int y){
        farm[x][y] = 2;
        if(farm[x+1][y] == 1){
            visited(x+1, y);
        }
        if(farm[x-1][y] == 1){
            visited(x-1, y);
        }
        if(farm[x][y+1] == 1){
            visited(x, y+1);
        }
        if(farm[x][y-1] == 1){
            visited(x, y-1);
        }
    }
}