import java.util.*;

import javax.swing.text.ElementIterator;

import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int tNum = Integer.parseInt(st.nextToken());
        int[] checklist = new int[n+1];
        for(int i = 0; i < tNum; i++){
            checklist[Integer.parseInt(st.nextToken())] = 1;
        }
        LinkedList<int[]> parties = new LinkedList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            int[] newElement = new int[tmp+1];
            newElement[0] = tmp;
            for(int j = 1; j < tmp+1; j++){
                newElement[j] = Integer.parseInt(st.nextToken());
            }
            parties.add(newElement);
        }
        while(true){
            int tmp = tNum;
            for(int[] party : parties){
                int flag = 0;
                for(int i = 0; i < party[0]; i++){
                    if(checklist[party[i+1]] == 1){
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    for(int i = 0; i < party[0]; i++){
                        if(checklist[party[i+1]] == 0){
                            checklist[party[i+1]] = 1;
                            tNum++;
                        }
                    }
                }
            }
            if(tNum == tmp){
                break;
            }
        }
        int cnt = m;
        for(int[] party : parties){
            for(int i = 0; i < party[0]; i++){
                if(checklist[party[i+1]] == 1){
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}