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
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long line[] = new long[k];
        long max = 0;
        for(int i = 0; i < k; i++){
            line[i] = Long.parseLong(br.readLine());
            max = max < line[i] ? line[i] : max;
        }
        int cnt;
        long cur_length;
        long left = 1;
        long right = max;
        long mid = 0;

        while(left <= right){
            mid = (left + right)/2;
            cnt = 0;
            for(int j = 0; j < k; j++){
                cur_length = line[j];
                while(true){
                    if(cnt > n)
                        break;
                    if(cur_length < mid)
                        break;
                    cnt++;
                    cur_length = cur_length - mid;
                }
            }
            //System.out.println(left + " " + mid + " " + right + " " + cnt);
            if(cnt >= n){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(right);
        
    }
}