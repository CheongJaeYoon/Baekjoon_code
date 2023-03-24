import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int frx = 0, fry = 0, fbx = 0, fby = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        char[][] board = new char[n][m];
        boolean[][][][]visited = new boolean[n][m][n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'R'){
                    frx = i;
                    fry = j;
                }
                if(board[i][j] == 'B'){
                    fbx = i;
                    fby = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{frx, fry, fbx, fby, 0});
        while(!queue.isEmpty()){
            int crx = queue.peek()[0];
            int cry = queue.peek()[1];
            int cbx = queue.peek()[2];
            int cby = queue.peek()[3];
            int cnt = queue.poll()[4];

            if(cnt >= 10){
                System.out.println("-1");
                return;
            }
            for(int i = 0; i < 4; i++){
                int nrx = crx;
                int nry = cry;
                int nbx = cbx;
                int nby = cby;
                int rd = 0;
                int bd = 0;

                while(board[nrx + dx[i]][nry + dy[i]] != '#' && board[nrx][nry] != 'O'){
                    nrx += dx[i];
                    nry += dy[i];
                    rd++;
                }
                while(board[nbx + dx[i]][nby + dy[i]] != '#' && board[nbx][nby] != 'O'){
                    nbx += dx[i];
                    nby += dy[i];
                    bd++;
                }
                if (board[nbx][nby] == 'O') continue;
                if (board[nrx][nry] == 'O'){
                    System.out.println(cnt + 1);
                    return;
                }

                if (nrx == nbx && nry == nby)
                {
                    if (rd > bd){
                        nrx -= dx[i];
                        nry -= dy[i];
                    }
                    else{
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }
                if (visited[nrx][nry][nbx][nby]) continue;
                visited[nrx][nry][nbx][nby] = true;
                queue.add(new int[]{nrx,nry,nbx,nby,cnt+1});
            }
        }
        
        System.out.println("-1");

    }
}