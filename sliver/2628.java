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
        int garo_len = Integer.parseInt(st.nextToken());
        int sero_len = Integer.parseInt(st.nextToken());

        ArrayList<Integer> garo = new ArrayList<>();
        ArrayList<Integer> sero = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        int tmp;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            tmp = Integer.parseInt(st.nextToken());
            if(tmp == 0){
                sero.add(Integer.parseInt(st.nextToken()));
            }
            else{
                garo.add(Integer.parseInt(st.nextToken()));
            }
        }
        garo.add(garo_len);
        sero.add(sero_len);

        Collections.sort(garo);
        Collections.sort(sero);

        int max_garo = 0;
        int max_sero = 0;
        int prev_num = 0;
        for(int num : garo){
            tmp = num - prev_num;
            max_garo = max_garo < tmp ? tmp : max_garo;
            prev_num = num;
        }
        prev_num = 0;
        for(int num : sero){
            tmp = num - prev_num;
            max_sero = max_sero < tmp ? tmp : max_sero;
            prev_num = num;
        }
        System.out.println(max_garo * max_sero);


    }


}