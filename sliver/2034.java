import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] key = {'A', 'Z', 'B', 'C', 'Z', 'D', 'Z', 'E', 'F', 'Z', 'G', 'Z'};

        int n = Integer.parseInt(br.readLine());
        int sheet_music[] = new int[n];
        
        for(int i = 0; i < n; i++){
            sheet_music[i] = Integer.parseInt(br.readLine());
        }
        int start, current;
        boolean check;
        for(int i = 0; i < 12; i++){
            start = i;
            current = start;
            check = true;
            if(i == 1 || i == 4 || i == 6 || i == 9 || i == 11)
                continue;
            for(int j = 0; j < n; j++){
                current += sheet_music[j];
                current = current < 0 ? 12 + current : current;
                current = current > 11 ? current - 12 : current;
                if(current == 1 || current == 4 || current == 6 || current == 9 || current == 11){
                    check = false;
                    break;
                }
            }
            if(check == true){
                System.out.println(key[start] + " " + key[current]);
            }
        }
    }
}