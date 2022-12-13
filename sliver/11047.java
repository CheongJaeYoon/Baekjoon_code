import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] units = new int[n];
        for(int i = 0; i < n;i++){
            units[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for(int i = n-1; i >=0; i--){
            while(k >= units[i]){
                k -= units[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}