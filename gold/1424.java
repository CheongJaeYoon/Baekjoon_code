import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        int totalTimeOfCd = L;
        int maxCnt = 1;
        while(true){
            if(totalTimeOfCd > C) break;
            totalTimeOfCd += (L+1);
            maxCnt++;
        }
        maxCnt--;
        if(maxCnt % 13 == 0){
            maxCnt--;
        }

        int cnt = 0;
        while(true){
            if(N == 0) break;
            if(N >= maxCnt){
                cnt++;
                N -= maxCnt;
            }
            else{
                if(N % 13 == 0){
                    if(cnt == 0){
                        cnt++;
                        N = 1;
                    }
                    else{
                        if(maxCnt - N == 1){
                            cnt++;
                            N = 1;
                        }
                        else{
                            cnt++;
                            N = 0;
                        }
                    }
                }
                else{
                    cnt++;
                    N = 0;
                }
            }
        }
        
        System.out.println(cnt);
    }
}