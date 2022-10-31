import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static int[] trees;
    public static int n;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        int max = 0;
        int min = 0;
        st = new StringTokenizer(br.readLine());
        int tmp = 0;
        for(int i = 0; i < n; i++){
            tmp = Integer.parseInt(st.nextToken());
            trees[i] = tmp;
            max = tmp > max ? tmp : max;
        }
        int mid = 0;
        long ltmp = 0;
        while(min <= max){
            mid = (min + max) / 2;
            ltmp = cut(mid);
            if(ltmp == m){
                break;
            }
            else if(ltmp < m){
                max = mid - 1;
            }
            else{
                min = mid + 1;
            }
        }
        if(cut(mid) < m){
            System.out.println(mid-1);
        }
        else{
            System.out.println(mid);
        }


    }

    public static long cut(int h){
        long sum = 0;
        for(int i = 0; i < n; i++){
            if(trees[i] > h){
                sum += (trees[i] - h);
            }
        }
        return sum;
    }


}