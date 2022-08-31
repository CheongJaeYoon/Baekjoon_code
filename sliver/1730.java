import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], 0);
        }
        int[] c_pos = {0, n-1};
        String command = br.readLine();
        char cur_c;
        int cut;
        int[] n_pos = new int[2];
        boolean ignore;
        for(int i = 0; i < command.length(); i++){
            cur_c = command.charAt(i);
            cut = 0;
            n_pos[0] = 0;
            n_pos[1] = 0;
            ignore = false;

            if(cur_c == 'R'){
                n_pos[0]++;
                cut = (1 << 0);
            } 
            if(cur_c == 'L'){
                n_pos[0]--;
                cut = (1 << 0);
            }
            if(cur_c == 'U'){
                n_pos[1]++;
                cut = (1 << 1);
            }
            if(cur_c == 'D'){
                n_pos[1]--;
                cut = (1 << 1);
            }
            
            if(c_pos[0] + n_pos[0] < 0){
                ignore = true;;
            }
            if(c_pos[0] + n_pos[0] >= n){
                ignore = true;;
            }
            if(c_pos[1] + n_pos[1] < 0){
                ignore = true;;
            }
            if(c_pos[1] + n_pos[1] >= n){
                ignore = true;;
            }
            if(!ignore){
                board[c_pos[0]][c_pos[1]] |= cut;
                c_pos[0] += n_pos[0];
                c_pos[1] += n_pos[1];
                board[c_pos[0]][c_pos[1]] |= cut;
            }
        }
        String result = "";
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < n; j++){
                if(board[j][i] == 0)
                    result += ".";
                if(board[j][i] == 1)
                    result += "-";
                if(board[j][i] == 2)
                    result += "|";
                if(board[j][i] == 3)
                    result += "+";
            }
            System.out.println(result);
            result = "";
        }
    }
}