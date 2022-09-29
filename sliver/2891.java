import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int broken[] = new int[n+2];
        int oneMore[] = new int[n+2];
        Arrays.fill(broken, 0);
        Arrays.fill(oneMore, 0);
        int tmp;
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < s; i++){
            broken[Integer.parseInt(st.nextToken())] = 1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < r; i++){
            tmp = Integer.parseInt(st.nextToken());
            if(broken[tmp] == 0)
                oneMore[tmp] = 1;
            else
                broken[tmp] = 0;
        }
        for(int i = 1; i < n+1; i++){
            if(broken[i] == 1){
                if(oneMore[i-1] == 1){
                    oneMore[i-1] = 0;
                    broken[i] = 0;
                }
                else if(oneMore[i+1] == 1){
                    oneMore[i+1] = 0;
                    broken[i] = 0;
                }
                else{
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }


}