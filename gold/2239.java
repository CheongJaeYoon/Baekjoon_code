import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static int[][] sudoku;
    public static ArrayList<int[]> blank;
    public static boolean done;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        blank = new ArrayList<int[]>();
        done = false;
        for(int i = 0; i < 9; i++){
            String str = br.readLine();
            for(int j = 0; j < 9; j++){
                int num = str.charAt(j) - '0';
                if(num == 0){
                    blank.add(new int[]{i, j});
                }
                else{
                    sudoku[i][j] = num;
                }
            }
        }
        func(0);
    }

    public static void func(int idx){
        if(done == true) return;
        if(blank.size() == idx){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(sudoku[i][j]);
                }
                if(i != 8) System.out.print("\n");
            }
            done = true;
            return;
        }

        boolean[] check = new boolean[10];
        int x = blank.get(idx)[0];
        int y = blank.get(idx)[1];
        //가로
        for(int i = 0; i < 9; i++){
            if(sudoku[x][i] != 0){
                check[sudoku[x][i]] = true;
            }
        }
        //세로
        for(int i = 0; i < 9; i++){
            if(sudoku[i][y] != 0){
                check[sudoku[i][y]] = true;
            }
        }
        //블럭
        for(int i = (x/3)*3; i < (x/3+1)*3; i++){
            for(int j = (y/3)*3; j < (y/3+1)*3; j++){
                if(sudoku[i][j] != 0){
                    check[sudoku[i][j]] = true;
                }
                
            }
        }

        for(int i = 1; i < 10; i++){
            if(check[i] == false){
                sudoku[x][y] = i;
                func(idx+1);
                sudoku[x][y] = 0;
            }
        }
    }
}