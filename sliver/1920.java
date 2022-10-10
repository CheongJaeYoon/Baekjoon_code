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
        st = new StringTokenizer(br.readLine());
        int[] array_A = new int[n];
        for(int i = 0 ; i < n ; i++){
            array_A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array_A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int tmp, left, right, mid;
        boolean exist;
        for(int i = 0; i < m ; i++){
            tmp = Integer.parseInt(st.nextToken());
            exist = false;
            left = 0;
            right = n - 1;
            while(left <= right){
                mid = (left + right) / 2;
                if(array_A[mid] == tmp){
                    exist = true;
                    break;
                }
                else if(array_A[mid] > tmp){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            if(exist == true){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }

    }
}