import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int size;
    public static ArrayList<int[]> arr;
    public static int[] str_arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder("");
        arr = new ArrayList<>();
        str_arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            int tmp2 = 0;
            boolean flag = true;
            for(int j = 0; j < arr.size(); j++){
                if(arr.get(j)[0] == tmp){
                    flag = false;
                    tmp2 = j;
                }
            }
            if(flag){
                arr.add(new int[]{tmp, 1});
            }
            else{
                arr.get(tmp2)[1]++;
            }
        }
        size = arr.size();
        arr.sort((e1, e2) -> e1[0]-e2[0]);
        func(0);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    public static void func(int cnt){
        if(cnt == m){
            for(int i = 0; i < m-1; i++){
                sb.append(str_arr[i] + " ");
            }
            sb.append(str_arr[m-1] + "\n");
        }
        else{
            for(int i = 0; i < size; i++){
                if(arr.get(i)[1] > 0){
                    arr.get(i)[1]--;
                    str_arr[cnt] = arr.get(i)[0];
                    func(cnt+1);
                    arr.get(i)[1]++;
                }
            }
        }
    }

}