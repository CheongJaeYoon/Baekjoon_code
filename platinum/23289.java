import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int r, c, k, w;
    static int[][] rooms;
    static int[][] temp;
    static boolean[][][] walls;
    static ArrayList<int[]> checkrooms = new ArrayList<>();
    static ArrayList<int[]> heaters = new ArrayList<>();
    static int[] dr = new int[] {0, 0, 0, -1, 1};
    static int[] dc = new int[] {0, 1, -1, 0, 0};
    static int[] subd1 = new int[] {0, 3, 3, 1, 1};
    static int[] subd2 = new int[] {0, 4, 4, 2, 2};
    static int chocolate = 0;
    public static void main(String[] args) throws Exception {
        r = readInt();
        c = readInt();
        k = readInt();
        rooms = new int[r][c];
        temp = new int[r][c];
        walls = new boolean[r][c][5];
        for(int row = 0; row < r; row++) {
            for(int col = 0; col < c; col++) {
                rooms[row][col] = readInt();
                if(rooms[row][col] == 5) {
                    checkrooms.add(new int[] {row, col});
                }
                else if(rooms[row][col] != 0) {
                    heaters.add(new int[] {row, col});
                }
            }
        }
        w = readInt();
        for(int i = 0; i < w; i++){
            int x = readInt()-1;
            int y = readInt()-1;
            int t = readInt();
            if(t == 0) {
                walls[x][y][3] = true;
                walls[x-1][y][4] = true;
            }
            else {
                walls[x][y][1] = true;
                walls[x][y+1][2] = true;
            }
        }
        while(true) {
            step1();
            step2();
            step3();
            step4();
            if(step5()) break;
            if(chocolate > 100) break;
        }
        System.out.print(chocolate);
    }

    private static void step1() {
        int[][] add = new int[r][c];
        for(int[] heater : heaters) {
            int[][] tmp = new int[r][c];
            simulateHeater(tmp, heater[0], heater[1], rooms[heater[0]][heater[1]]);
            sum(add, tmp);
        }
        sum(temp, add);
    }

    private static void sum(int[][] add, int[][] tmp) {
        for(int row = 0; row < r; row++) {
            for(int col = 0; col < c; col++) {
                add[row][col] += tmp[row][col];
            }
        }
    }

    private static void simulateHeater(int[][] tmp, int hr, int hc, int d) {
        int curHeat = 5;
        int nr = hr + dr[d];
        int nc = hc + dc[d];
        dfs(nr, nc, d, curHeat, tmp);
    }

    private static void dfs(int row, int col, int d, int curHeat, int[][] tmp) {
        tmp[row][col] = curHeat;
        if(curHeat == 1) return;
        curHeat--;
        int nr, nc;
        if(!walls[row][col][subd1[d]]) {
            nr = row + dr[subd1[d]];
            nc = col + dc[subd1[d]];
            if(!(nr < 0 || nc < 0 || nr >= r || nc >= c) && !walls[nr][nc][d]) {
                nr = nr + dr[d];
                nc = nc + dc[d];
                if(!(nr < 0 || nc < 0 || nr >= r || nc >= c) && tmp[nr][nc] != curHeat) {
                    tmp[nr][nc] = curHeat;
                    dfs(nr, nc, d, curHeat, tmp);
                }
            }
        }
        if(!walls[row][col][subd2[d]]) {
            nr = row + dr[subd2[d]];
            nc = col + dc[subd2[d]];
            if(!(nr < 0 || nc < 0 || nr >= r || nc >= c) && !walls[nr][nc][d]) {
                nr = nr + dr[d];
                nc = nc + dc[d];
                if(!(nr < 0 || nc < 0 || nr >= r || nc >= c) && tmp[nr][nc] != curHeat) {
                    tmp[nr][nc] = curHeat;
                    dfs(nr, nc, d, curHeat, tmp);
                }
            }
        }
        if(!walls[row][col][d]) {
            nr = row + dr[d];
            nc = col + dc[d];
            if(!(nr < 0 || nc < 0 || nr >= r || nc >= c) && tmp[nr][nc] != curHeat) {
                tmp[nr][nc] = curHeat;
                dfs(nr, nc, d, curHeat, tmp);
            }
        }
    }

    private static void step2() {
        int[][] tmp = new int[r][c];
        for(int row = 0; row < r; row++) {
            for(int col = 0; col < c; col++) {
                for(int i = 1; i < 5; i++) {
                    int nr = row + dr[i];
                    int nc = col + dc[i];
                    if(nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                    if(walls[row][col][i]) continue;
                    int diff = temp[row][col] - temp[nr][nc];
                    if(diff > 0) {
                        int num = diff/4;
                        if(num > 0) {
                            tmp[nr][nc] += num;
                            tmp[row][col] -= num;
                        }
                    }
                }
            }
        }
        sum(temp, tmp);
    }

    private static void step3() {
        for(int row = 0; row < r; row ++ ) {
            if(temp[row][0] > 0) temp[row][0]--;
            if(temp[row][c-1] > 0) temp[row][c-1]--;
        }
        for(int col = 1; col < c-1; col++) {
            if(temp[0][col] > 0) temp[0][col]--;
            if(temp[r-1][col] > 0) temp[r-1][col]--;
        }
    }

    private static void step4() {
        chocolate++;
    }

    private static boolean step5() {
        for(int[] room : checkrooms) {
            if(temp[room[0]][room[1]] < k) return false;
        }
        return true;
    }

    public static int readInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}
