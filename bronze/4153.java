import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] edges = new Integer[3];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[0] = Integer.parseInt(st.nextToken());
            edges[1] = Integer.parseInt(st.nextToken());
            edges[2] = Integer.parseInt(st.nextToken());
            if(edges[0] == 0 && edges[1] == 0 && edges[2] == 0)
                break;
            Arrays.sort(edges);
            if(edges[2] * edges[2] == edges[0] * edges[0] + edges[1] * edges[1]){
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }

        }
    }
}