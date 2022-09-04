import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int boom = 200;

        int map[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(map[i], 0);
        }

        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < n; j++){
                if(line.charAt(j) != '.'){
                    map[i][j] = boom;
                    int tmp = line.charAt(j) - '0';
                    for(int m = -1; m < 2; m++){
                        for(int k = -1; k < 2; k++){
                            if(i + m >=0 && i + m < n && j + k >= 0 && j + k < n){
                                map[i + m][j + k] += tmp;
                            }
                        }
                    }
                    
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] >= boom)
                    result.append("*");
                else if(map[i][j] > 9 && map[i][j] < boom)
                    result.append("M");
                else
                    result.append(map[i][j]);

            }
            if(i != n-1)
                result.append("\n");
        }
        System.out.println(result.toString());

    }
}