import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class Main {

    public static boolean[][] borad = new boolean[6][6];
    public static int[] prev_pos = new int[2]; //[col, row]

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        int[][] input = new int[36][2];

        for(int i = 0; i < 36; i++){
            str = br.readLine();
            input[i][0] = (int)(str.charAt(0) - 'A');
            input[i][1] = (int)(str.charAt(1) - '1');

        }

        int row, col;

        col = input[0][0];
        row = input[0][1];
        
        prev_pos[0] = col;
        prev_pos[1] = row;
        borad[col][row] = true;

        
        for(int i = 1; i < 36; i++){
            
            col = input[i][0];
            row = input[i][1];

            if(!is_vaild(col, row)){
                System.out.println("Invalid");
                return;
            }
            else{
                borad[col][row] = true;
                prev_pos[0] = col;
                prev_pos[1] = row;
            }
        }
        if(is_vaild(col, row, input[0][0], input[0][1]))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
        return;
    }

    public static boolean is_vaild(int col, int row) {
        if(borad[col][row] == true)
            return false;

        int a = Math.abs(col - prev_pos[0]);
        int b = Math.abs(row - prev_pos[1]);

        if((a == 2 && b == 1) || (a == 1 && b == 2))
            return true;
        else
            return false;
    }

    public static boolean is_vaild(int col, int row, int col2, int row2) {
        int a = Math.abs(col - col2);
        int b = Math.abs(row - row2);

        if((a == 2 && b == 1) || (a == 1 && b == 2))
            return true;
        else
            return false;
    }
}