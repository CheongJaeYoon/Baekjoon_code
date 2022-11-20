import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = e;
            arr[i][1] = e-s;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                    return b[1] - a[1];
                return a[0] - b[0];
            }
        });
        int prev_end;
        int cnt = 1;
        prev_end = arr[0][0];
        for(int i = 1; i < n; i++){
            if(prev_end <= arr[i][0]- arr[i][1]){
                prev_end = arr[i][0];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}