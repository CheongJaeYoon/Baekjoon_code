import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Integer[] cards = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        int tmp = 300000;
        int result = 0;
        for(int a = 0; a < n; a++){
            for(int b = a+1; b < n; b++){
                for(int c = b+1; c < n; c++){
                    sum = cards[a] + cards[b] + cards[c];
                    if( m - sum >= 0 && m - sum < tmp){
                        result = sum;
                        tmp = m - sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}