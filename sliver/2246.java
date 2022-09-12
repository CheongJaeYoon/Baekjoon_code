import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        int[] c = new int[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        boolean check;

        for(int i = 0; i < n; i++){
            check = true;
            for(int j = 0; j < n;j ++){
                if(i == j)
                    continue;
                if(d[i] > d[j]){
                    if(c[i] >= c[j])
                        check = false;
                }
                else if(c[i] > c[j]){
                    if(d[i] >= d[j])
                        check = false;
                }
            }
            if(check == true){
                cnt++;
            }
        }

        System.out.println(cnt);
    }


}