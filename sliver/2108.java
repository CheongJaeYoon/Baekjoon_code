import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] number_arr = new Integer[n];
        double sum = 0;
        int tmp;
        for(int i = 0; i < n; i++){
            tmp = Integer.parseInt(br.readLine());
            number_arr[i] = tmp;
            sum += tmp;
        }
        Arrays.sort(number_arr);
        int max = 1;
        boolean second = false;
        int mode = number_arr[0];
        tmp = mode; //현재숫자
        int tmp2 = 1; //나온 개수
        for(int i = 1; i < n; i++){
            if(number_arr[i] == tmp){
                tmp2++;
                if(tmp2 > max){
                    second = false;
                    mode = number_arr[i];
                    max = tmp2;
                }
                else if(tmp2 == max && second == false){
                    second = true;
                    mode = number_arr[i];
                }
            }
            else{
                tmp2 = 1;
                tmp = number_arr[i];
                if(tmp2 == max && second == false){
                    second = true;
                    mode = number_arr[i];
                }
            }
        }
        System.out.println(Math.round(sum/n));
        System.out.println(number_arr[n/2]);
        System.out.println(mode);
        System.out.println(number_arr[n-1] - number_arr[0]);

    }
}