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

        for(int i = 0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }
        double[] edge = new double[3];
        edge[0] = Math.sqrt(Math.pow(dot[0][0] - dot[1][0], 2) + Math.pow(dot[0][1] - dot[1][1], 2));
        edge[1] = Math.sqrt(Math.pow(dot[1][0] - dot[2][0], 2) + Math.pow(dot[1][1] - dot[2][1], 2));
        edge[2] = Math.sqrt(Math.pow(dot[2][0] - dot[0][0], 2) + Math.pow(dot[2][1] - dot[0][1], 2));

        double[] angle = new double[3];
        angle[0] = getAngle(edge[0], edge[1], edge[2]);
        angle[1] = getAngle(edge[1], edge[2], edge[0]);
        angle[2] = getAngle(edge[2], edge[0], edge[1]);

        double max = 0.0;
        for (double d : angle) {
            max = max < d ? d : max;
        }

        //case 1
        if(slope(dot[0], dot[1]) == slope(dot[1], dot[2])){
            System.out.println("X");
            return;
        }
        //case 2
        if(edge[0] == edge[1] && edge[1] == edge[2]){
            System.out.println("JungTriangle");
            return;
        }
        //case 3
        if(edge[0] == edge[1] || edge[1] == edge[2] || edge[0] == edge[2]){
            if(max >= 90.0000001){
                System.out.println("Dunkak2Triangle");
                return;
            }
            if(90.0000001 > max  && max > 89.9999999){
                System.out.println("Jikkak2Triangle");
                return;
            }
            if(max <= 89.9999999){
                System.out.println("Yeahkak2Triangle");
                return;
            }
        }
        //case 4
        if(max >= 90.0000001){
            System.out.println("DunkakTriangle");
            return;
        }
        if(90.0000001 > max  && max > 89.9999999){
            System.out.println("JikkakTriangle");
            return;
        }
        if(max <= 89.9999999){
            System.out.println("YeahkakTriangle");
            return;
        }

    }

    static double slope(int[] a, int[] b){
        if((a[1] - b[1]) == 0)
            return 99999999999999.0;
        double result = (a[0] - b[0])/(a[1] - b[1]);
        return result;
    }

    static double getAngle(double a, double b, double c){
        double radian = Math.acos((a*a + b*b - c*c) / (2 * a * b));
        double degree = radian / Math.PI * 180;
        return degree;
    }
}