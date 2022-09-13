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
        int[][] card = new int[n][5];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                card[i][j] =Integer.parseInt(st.nextToken());
            }
        }
        
        int max = -1;;
        int result = 0;
        int tmp;

        for(int i = 0; i < n ;i++){
            tmp = maxnumber(card[i]);
            if(tmp >= max){
                result = i;
                max = tmp;
            }
        }
        System.out.println(result+1);


    }
    public static int maxnumber(int[] arr){
        int max = -1;
        int tmp;
        for(int a = 0; a < 5; a++){
            for(int b = a+1; b < 5; b++){
                for(int c = b+1; c < 5; c++){
                    tmp = (arr[a] + arr[b] + arr[c]) % 10;
                    max = tmp > max ? tmp : max;
                }
            }
        }
        return max;
    }


}