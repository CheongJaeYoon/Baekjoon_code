import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] picture = new int[101][101];
        for(int i = 0; i < 101; i++){
            Arrays.fill(picture[i], 0);
        }
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        for(int i = 0; i < n; i++){
            tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int c = Integer.parseInt(tmp[2]);
            int d = Integer.parseInt(tmp[3]);
            for(int x = a; x <= c; x++){
                for(int y = b; y <= d; y++){
                    picture[x][y]++;
                }
            }
            
        }
        int cnt = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(picture[i][j] > m)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}