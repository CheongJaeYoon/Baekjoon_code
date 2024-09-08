import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Main{

    static int n,m, cctvNum, min;
    static int[][] map;
    static ArrayList<int[]> cctvLoc = new ArrayList<>();
    static int[] arr;
    static int[] dr = new int[] {-1, 0, 1, 0};
    static int[] dc = new int[] {0, 1, 0, -1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    public static void main(String[] args) throws Exception{
        n = readInt();
        m = readInt();
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = readInt();
                if(map[i][j] > 0 && map[i][j] < 6) cctvLoc.add(new int[] {i, j, map[i][j]});
            }
        }
        cctvNum = cctvLoc.size();
        arr = new int[cctvNum];
        min = Integer.MAX_VALUE;

        dfs(0);
        System.out.print(min);
    }

    private static void dfs(int idx) {
        if(idx == cctvNum) {
            countArea();
        }
        else {
            switch(cctvLoc.get(idx)[2]) {
                case 1:
                    for(int i = 0; i < 4; i++) {
                        arr[idx] = i;
                        dfs(idx+1);
                    }
                    break;
                case 2:
                    for(int i = 0; i < 2; i++) {
                        arr[idx] = i;
                        dfs(idx+1);
                    }
                    break;
                case 3:
                    for(int i = 0; i < 4; i++) {
                        arr[idx] = i;
                        dfs(idx+1);
                    }
                    break;
                case 4:
                    for(int i = 0; i < 4; i++) {
                        arr[idx] = i;
                        dfs(idx+1);
                    }
                    break;
                case 5:
                    dfs(idx+1);
                    break;
            }
        }

    }

    private static void countArea() {
        for(int i = 0; i < cctvNum; i++) {
            drawSharp(cctvLoc.get(i)[0], cctvLoc.get(i)[1], cctvLoc.get(i)[2], arr[i]);
        }
        int cnt = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(map[r][c] == 0) cnt++;
            }
        }
        min = Math.min(min, cnt);
        deleteSharp();
    }

    private static void drawSharp(int r, int c, int type, int dir) {
        switch(type) {
            case 1:
                drawline(r, c, dir);
                break;
            case 2:
                drawline(r, c, dir);
                drawline(r, c, (dir+2)%4);
                break;
            case 3:
                drawline(r, c, dir);
                drawline(r, c, (dir+1)%4);
                break;
            case 4:
                drawline(r, c, dir);
                drawline(r, c, (dir+1)%4);
                drawline(r, c, (dir+3)%4);
                break;
            case 5:
                drawline(r, c, dir);
                drawline(r, c, (dir+1)%4);
                drawline(r, c, (dir+2)%4);
                drawline(r, c, (dir+3)%4);
                break;
        }
    }
    private static void drawline(int r, int c, int dir) {
        int nr = r;
        int nc = c;
        while(true) {
            nr += dr[dir];
            nc += dc[dir];
            if(nr < 0 || nc < 0 || nr >= n || nc >= m) break;
            if(map[nr][nc] == 6) break;
            if(map[nr][nc] == 7) continue;
            if(map[nr][nc] > 0) continue;
            if(map[nr][nc] == 0) map[nr][nc] = 7;
        }

    }
    private static void deleteSharp() {
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(map[r][c] == 7) map[r][c] = 0;
            }
        }
    }

    public static int readInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }
}