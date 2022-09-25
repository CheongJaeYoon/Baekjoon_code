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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int types[] = new int[5];
        boolean tmp2[] = new boolean[n];
        Arrays.fill(tmp2, false);
        Arrays.fill(types, 0);
        String[] tmp;
        int type = 0;


        br.readLine();

        for(int i = 0; i < 5 * m; i++){

            type = i % 5;
            if(type == 4){
                br.readLine();
                for(int k = 0; k < n; k++){
                    if(tmp2[k] == false){
                        tmp2[k] = true;
                        types[type]++;
                    }
                }
                Arrays.fill(tmp2, false);
                continue;
            }

            tmp = br.readLine().split("#");

            for(int j = 1; j < n + 1; j++){
                if(tmp[j].charAt(2) == '.'){
                    if(tmp2[j-1] == false){
                        tmp2[j-1] = true;
                        types[type]++;
                    }
                }
            }
        }
        System.out.print(types[0]);
        for(int i = 1; i < 5; i++){
            System.out.print(" " + types[i]);
        }
    }


}