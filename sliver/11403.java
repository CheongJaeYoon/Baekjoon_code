import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                arr[i][j] = (tmp==0?3: 1);
            }
        }
        for(int m = 0; m<n; m++){
            for(int s = 0; s<n; s++){
                for(int e = 0; e<n; e++){
                    if (arr[s][e] > arr[s][m] + arr[m][e])
                        arr[s][e] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    if(arr[i][j] == 3)
                        System.out.print(0);
                    else
                        System.out.print(1);
                }
                else{
                    if(arr[i][j] == 3)
                        System.out.print(" "+0);
                    else
                        System.out.print(" "+1);

                }
            }
            System.out.print('\n');
        }
    }
}