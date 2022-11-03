import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

import org.xml.sax.SAXException;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        int[] ranks = new int[n];
        int i = 0, j = 0;
        for(i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int rank = 0;
        for(i = 0; i < n; i++){
            rank = 0;
            for(j = 0; j < n; j++){
                if(i == j){
                    rank++;
                    continue;
                }
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    rank++;
            }
            ranks[i] = rank;
        }
        for(i = 0; i < n-1; i++){
            System.out.print(ranks[i] + " ");
        }
        System.out.println(ranks[n-1]);
    }
}