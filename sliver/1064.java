import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[][] dot = new int[3][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<3; i++){
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        if((dot[0][0] - dot[1][0]) * (dot[1][1] - dot[2][1]) == (dot[0][1] - dot[1][1]) * (dot[1][0] - dot[2][0])){
            System.out.println(-1.0);
            return;
        }
        double[] edge = new double[3];
        double max, min;
        edge[0] = Math.sqrt(Math.pow(dot[0][0] - dot[1][0], 2) + Math.pow(dot[0][1] - dot[1][1], 2));
        edge[1] = Math.sqrt(Math.pow(dot[1][0] - dot[2][0], 2) + Math.pow(dot[1][1] - dot[2][1], 2));
        edge[2] = Math.sqrt(Math.pow(dot[2][0] - dot[0][0], 2) + Math.pow(dot[2][1] - dot[0][1], 2));
        max = edge[0];
        min = edge[0];

        for(int i = 0; i < 3; i++){
            if(edge[i] == 0){
                System.out.println(-1.0);
                return;
            }
            max = max < edge[i] ? edge[i] : max;
            min = min > edge[i] ? edge[i] : min;
        }
        System.out.println(2 * (max - min));
        
    }

}