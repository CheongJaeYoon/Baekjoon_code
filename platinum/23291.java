import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int n, k;
    static int[][] field;
    public static void main(String[] args) throws Exception{
        int cnt = 0;
        n = readInt();
        k = readInt();
        field = new int[n+1][n+1];
        for(int i = 0; i < n; i++){
            field[0][i] = readInt();
        }
        while(true){
            step1();
            step2();
            step3();
            cnt++;
            if(isFinish()) break;
        }
        System.out.println(cnt);
    }

    public static int readInt() throws Exception{
        st.nextToken();
        return (int) st.nval;
    }

    public static void step1(){
        int min = field[0][0];
        for(int i = 0; i < n; i++){
            min = Math.min(min ,field[0][i]);
        }
        for(int i = 0; i < n; i++){
            if(field[0][i] == min) field[0][i]++;
        }
    }

    public static void step2(){
        int r = 1;
        int c = 1;
        int len = n-1;
        while(true){
            if(len < r) break;
            for(int row = 0; row < r; row++){
                for(int col = 0; col < c; col++){
                    field[c-col][c+row] = field[row][col];
                }
            }
            for(int col = c; col < n; col++){
                for(int row = 0; row < n; row++){
                    if(field[row][col] == 0) continue;
                    field[row][col - c] = field[row][col];
                    field[row][col] = 0;
                }
            }
            if(r == c){
                r++;
            }
            else{
                c++;
            }
            len = len - c;
        }

        int[][] tmp = new int[n][n];
        //가로
        for(int col = 0; col < c-1; col++){
            for(int row = 1; row < r; row++){
                diffGaro(row, col, tmp);
            }
        }
        for(int col = 0; col < c + len - 1; col++){
            diffGaro(0, col, tmp);
        }
        //세로
        for(int row = 0; row < r-1; row++){
            for(int col = 0; col < c; col++){
                diffCero(row, col, tmp);
            }
        }

        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++) {
                if(tmp[row][col] != 0){
                    field[row][col] += tmp[row][col];
                }
            }
        }

        int cnt = 0;
        for(int col = 0; col < c; col++){
            for(int row = 0; row < r; row++){
                field[r][cnt] = field[row][col];
                field[row][col] = 0;
                cnt++;
            }
        }
        for(int i = 0; i < len; i++){
            field[r][cnt] = field[0][c+i];
            field[0][c+i] = 0;
            cnt++;
        }
        for(int i = 0; i < n; i++){
            field[0][i] = field[r][i];
            field[r][i] = 0;
        }

    }

    public static void step3(){
        int unit = n/4;
        for(int i = 0; i < unit; i++){
            field[4][i] = field[0][3*unit + i];
            field[1][i] = field[0][unit-1 - i];
            field[2][i] = field[0][unit + i];
            field[3][i] = field[0][3*unit-1 - i];
            field[0][3*unit + i] = 0;
            field[0][unit-1 - i] = 0;
            field[0][unit + i] = 0;
            field[0][3*unit-1 - i] = 0;
        }
        for(int i = 0; i < unit; i++){
            field[0][i] = field[4][i];
            field[4][i] = 0;
        }
        int[][] tmp = new int[n][n];
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < unit-1; col++){
                diffGaro(row, col, tmp);
            }
        }
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < unit; col++){
                diffCero(row, col, tmp);
            }
        }
        for(int row = 0; row < 4; row++){
            for(int col = 0; col < unit; col++){
                field[row][col] += tmp[row][col];
            }
        }

        int cnt = 0;
        for(int col = 0; col < unit; col++){
            for(int row = 0; row < 4; row++){
                field[4][cnt] = field[row][col];
                field[row][col] = 0;
                cnt++;
            }
        }
        for(int i = 0; i < n ;i++){
            field[0][i] = field[4][i];
            field[4][i] = 0;
        }
    }

    public static boolean isFinish(){
        int max = field[0][0];
        int min = field[0][0];
        for(int i = 0; i < n; i++){
            max = Math.max(max, field[0][i]);
            min = Math.min(min, field[0][i]);
        }
        if((max - min) <= k) return true;
        else return false;
    }

    public static void diffGaro(int row, int col, int[][] tmp){
        if(field[row][col] == 0 || field[row][col+1] == 0) return;
        if(field[row][col] > field[row][col+1]){
            int num = (field[row][col] - field[row][col+1])/5;
            tmp[row][col+1] += num;
            tmp[row][col] -= num;
        }
        else if(field[row][col] < field[row][col+1]){
            int num = (field[row][col+1] - field[row][col])/5;
            tmp[row][col] += num;
            tmp[row][col+1] -= num;
        }
    }

    public static void diffCero(int row, int col, int[][] tmp){
        if(field[row][col] == 0 || field[row+1][col] == 0) return;
        if(field[row][col] > field[row+1][col]){
            int num = (field[row][col] - field[row+1][col])/5;
            tmp[row+1][col] += num;
            tmp[row][col] -= num;
        }
        else if(field[row][col] < field[row+1][col]){
            int num = (field[row+1][col] - field[row][col])/5;
            tmp[row][col] += num;
            tmp[row+1][col] -= num;
        }
    }
}
