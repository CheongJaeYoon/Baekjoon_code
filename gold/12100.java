import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static int maxBlock;
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        maxBlock = -1;
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, board);
        System.out.println(maxBlock);
    }

    public static void func(int cnt, int[][] map){
        if(cnt >= 5){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n ;j++){
                    maxBlock = Math.max(maxBlock, map[i][j]);
                }
            }
            return;
        }

        int[][] copy = new int[n][n];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < n; j++){
                copy[j] = map[j].clone();
            }
            move(i, copy);
            func(cnt+1, copy);
        }

    }

    public static void move(int dir, int[][] map){
        if(dir == 0){
            for(int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for(int j = 0; j < n; j++) {
                    if(map[j][i] != 0) {
                        if(block == map[j][i]) {
                            map[index - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                        else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index++;
                        }
                    }
                }
            }
        }
        if(dir == 1){
            for(int i = 0; i < n; i++) {
                int index = n - 1;
                int block = 0;
                for(int j = n - 1; j >= 0; j--) {
                    if(map[j][i] != 0) {
                        if(block == map[j][i]) {
                            map[index + 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                        else {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[index][i] = block;
                            index--;
                        }
                    }
                }
            }
        }
        if(dir == 2){
            for(int i = 0; i < n; i++) {
                int index = 0;
                int block = 0;
                for(int j = 0; j < n; j++) {
                    if(map[i][j] != 0) {
                        if(block == map[i][j]) {
                            map[i][index - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index++;
                        }
                    }
                }
            }
        }
        if(dir == 3){
            for(int i = 0; i < n; i++) {
                int index = n - 1;
                int block = 0;
                for(int j = n - 1; j >= 0; j--) {
                    if(map[i][j] != 0) {
                        if(block == map[i][j]) {
                            map[i][index + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                        else {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][index] = block;
                            index--;
                        }
                    }
                }
            }
        }

    }
}
