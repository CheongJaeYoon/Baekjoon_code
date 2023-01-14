import java.io.*;
import java.util.*;

public class Main{
    public static int[] in;
    public static int[] post;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder("");
        int n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            post[i] = Integer.parseInt(st.nextToken());
        }
        func(0, n - 1, 0, n - 1);
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
    }
    public static void func(int is, int ie, int ps, int pe){
        if(ie - is < 0){
            return;
        }
        if(ie - is == 0){
            sb.append(in[is] + " ");
            return;
        }
        int middle = 0;
        for(int i = is; i < ie; i++){
            if(in[i] == post[pe]){
                break;
            }
            middle++;
        }
        sb.append(in[is + middle] + " ");
        func(is, is + middle - 1, ps, ps + middle - 1);
        func(is + middle + 1, ie, ps + middle, pe - 1);

    }
}