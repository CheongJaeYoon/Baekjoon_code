import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(arr[0]);
        int cnt = 1;

        for(int i = 1; i < n; i++){
            int now = arr[i];

            if(list.get(cnt-1) < now){
                cnt++;
                list.add(now);
            }
            else{
                int tmp = Collections.binarySearch(list, now);
                tmp = tmp < 0? -(tmp+1) : tmp;
                list.set(tmp, now);
            }
        }
        System.out.println(cnt);

    }
}
