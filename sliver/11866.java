import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        StringBuilder sb = new StringBuilder("<");

        int idx = k - 1;
        int len = n;
        while(len != 0){
            if(idx >= len){
                idx = idx % len;
            }
            if(len != 1)
                sb.append(arr[idx] + ", ");
            else
                sb.append(arr[idx]);
            len--;
            arr = remove(arr, idx);
            idx += k-1;
        }
        sb.append(">");
        System.out.println(sb.toString());
    }

    private static int[] remove(int[] a, int index)
    {
        if (a == null || index < 0 || index >= a.length) {
            return a;
        }
 
        int[] result = new int[a.length - 1];
 
        System.arraycopy(a, 0, result, 0, index);
        System.arraycopy(a, index + 1, result, index, a.length - index - 1);
 
        return result;
    }


}