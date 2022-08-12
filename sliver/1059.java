import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int l;
        int[] s;
        int n;

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = new int[l];
        for(int i = 0; i < l; i++){
            s[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(s);

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int min, max;
        min = 1001;
        max = 0;

        for(int i = 0; i < l; i++){
            if(s[i] == n){
                System.out.println(0);
                return;
            }
            else{
                if(i == 0){
                    if(1 <= n && n <= s[i]){
                        min = 0;
                        max = s[i];
                    }
                }
                else{
                    if(s[i-1] <= n && n <= s[i]){
                        min = s[i-1];
                        max = s[i];
                    }
                }
            }
        }
        System.out.println((n - min)*(max - n) - 1);
        return;
    }
}