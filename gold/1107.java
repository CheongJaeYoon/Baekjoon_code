import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static int m;
    public static int[] block_num;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        block_num = new int[m];
        if(m > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                block_num[i] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(block_num);

        int cnt = 0;
        cnt = Math.abs(n - 100);
        int tmp_cnt = 0;
        for(int i = 0; i < 1000000; i++){
            
            if(isBlock(i)){
                continue;
            }
            tmp_cnt = 0;
            tmp_cnt += (Integer.toString(i).length());
            tmp_cnt += Math.abs(i - n);
            cnt = tmp_cnt < cnt ? tmp_cnt : cnt;
        }

        System.out.println(cnt);

    }
    public static boolean isBlock(int num){
        int tmp = num;
        boolean isblock = false;
        int tmp2 =0 ;

        if(num == 0){
            for(int i = 0; i < m; i++){
                if(0 == block_num[i]){
                    isblock = true;
                    break;
                }
            }
        }

        while(tmp != 0){
            tmp2 = tmp % 10;
            for(int i = 0; i < m; i++){
                if(tmp2 == block_num[i]){
                    isblock = true;
                    break;
                }
            }
            if(isblock == true)
                break;
            tmp /= 10;
        }

        return isblock;
    }

}