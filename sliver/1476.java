import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] esm = br.readLine().split(" ");
        int e = Integer.parseInt(esm[0]);
        int s = Integer.parseInt(esm[1]);
        int m = Integer.parseInt(esm[2]);

        int e_cnt = 1;
        int s_cnt = 1;
        int m_cnt = 1;

        int cnt = 1;

        while(true){
            if(e_cnt == 16)
                e_cnt = 1;
            if(s_cnt == 29)
                s_cnt = 1;
            if(m_cnt == 20)
                m_cnt = 1;
            
            if(e == e_cnt && s == s_cnt && m == m_cnt)
                break;
            
            e_cnt++;
            s_cnt++;
            m_cnt++;
            cnt++;
        }
        System.out.println(cnt);
    }
}