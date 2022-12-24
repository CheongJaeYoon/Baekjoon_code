import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] name = new String[n];
        int[] number = new int[n];
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            number[i] = Integer.parseInt(st.nextToken());
        }
        while(m-- > 0){
            int tmp = Integer.parseInt(br.readLine());

            int l = 0;
            int r = n-1;
            int mid = (l + r)/2;
            while(l <= r){
                if(tmp > number[mid]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
                mid = (l + r)/2;
            }
            mid = l;
            sb.append(name[mid]);
            if(m != 0){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}