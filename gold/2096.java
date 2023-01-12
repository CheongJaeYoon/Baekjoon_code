import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[3];
        int min[][] = new int[2][3];
        int max[][] = new int[2][3];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                if(i == 0){
                    min[0][j] = arr[j];
                    max[0][j] = arr[j];
                }
            }
            if(i > 0){
                for(int j = 0; j < 3; j++){
                    if(j == 0){
                        min[1][j] = Math.min(min[0][j], min[0][j+1]) + arr[j];
                        max[1][j] = Math.max(max[0][j], max[0][j+1]) + arr[j];
                    }
                    else if(j == 2){
                        min[1][j] = Math.min(min[0][j], min[0][j-1]) + arr[j];
                        max[1][j] = Math.max(max[0][j], max[0][j-1]) + arr[j];
                    }
                    else{
                        min[1][j] = Math.min(Math.min(min[0][j], min[0][j-1]), min[0][j+1]) + arr[j];
                        max[1][j] = Math.max(Math.max(max[0][j], max[0][j-1]), max[0][j+1]) + arr[j];
                    }
                }
                for(int j = 0; j < 3; j++){
                    min[0][j] = min[1][j];
                    max[0][j] = max[1][j];
                }

            }
        }
        
        if(n == 1){
            for(int i = 0; i < 3; i++){
                min[1][i] = min[0][i];
                max[1][i] = max[0][i];
            }

        }
        int max_value = max[1][0];
        int min_value = min[1][0];
        for(int i = 1; i < 3; i++){
            max_value = max_value < max[1][i] ? max[1][i] : max_value;
            min_value = min_value > min[1][i] ? min[1][i] : min_value;
        }
        System.out.println(max_value + " " + min_value);
    }
}