import java.io.*;
import java.util.*;

public class Main{
    public static ArrayList<Integer> in;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder("");
        in = new ArrayList<>();
        int n = 0;
        while(true){
            String str = br.readLine();
            if(str == null || str.equals("")){
                break;
            }
            in.add(Integer.parseInt(str));
            n++;
        }

        func(0, n-1);

        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
    }
    public static void func(int start, int end){
        if(start == end){
            sb.append(in.get(start) + "\n");
            return;
        }
        int mid = -1;
        for(int i = start; i <= end; i++){
            if(in.get(start) < in.get(i)){
                mid = i;
                break;
            }
        }
        if(mid == -1){ // 다 작은 경우
            func(start+1, end);
            sb.append(in.get(start) + "\n");
        }
        else{
            if(mid == start+1){ // 다 큰 경우
                func(start+1, end);
                sb.append(in.get(start) + "\n");
            }
            else{
                func(start+1, mid-1);
                func(mid, end);
                sb.append(in.get(start) + "\n");
            }
        }
    }
}