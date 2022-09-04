import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int arr_len;
        int[] arr;
        int num;
        List<temp> result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        arr_len = Integer.parseInt(st.nextToken());
        arr = new int[arr_len];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<arr_len; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());


        
    }

}

class temp {
    int key;
    int value;

    temp(int key, int value){
        this.key = key;
        this.value = value;
    }
}