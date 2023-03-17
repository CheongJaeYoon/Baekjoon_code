import java.util.*;

import javax.xml.stream.events.EndElement;

import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            boolean isfd = true;
            while(s <= e){
                if(arr[s] != arr[e]){
                    isfd = false;
                    break;
                }
                s++;
                e--;
            }
            if(isfd == true){
                sb.append("1\n");
            }
            else{
                sb.append("0\n");
            }

        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}