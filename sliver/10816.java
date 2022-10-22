import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number[] = new int[20000001];
        Arrays.fill(number, 0);
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(n-- > 0){
            number[Integer.parseInt(st.nextToken())+10000000]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sb.append(number[Integer.parseInt(st.nextToken())+10000000]);
        while(m-- > 1){
            sb.append(" " + number[Integer.parseInt(st.nextToken())+10000000]);
        }
        System.out.println(sb.toString());

    }


}