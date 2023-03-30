import java.util.*;
import java.io.*;

public class Main {
	static Shark[][] map;
	static int R, C, M;
    static int sum;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        sum = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if(d - 1 < 2){
                s = s % ((R-1)*2);
            }
            else{
                s = s % ((C-1)*2);
            }
            map[r-1][c-1] = new Shark(r-1, c-1, s, d - 1, z);
        }

        for(int i = 0; i < C; i++){
            fishing(i);
            move();
        }
        System.out.println(sum);
    }

    public static void fishing(int col){
        for(int r = 0; r < R; r++){
            if(map[r][col] != null){
                sum += map[r][col].size;
                map[r][col] = null;
                break;
            }
        }
    }

    public static void move(){
        LinkedList<Shark> sharks = new LinkedList<>();
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(map[r][c] != null){
                    sharks.add(map[r][c]);
                    map[r][c] = null;
                }
            }
        }
        while(!sharks.isEmpty()){
            Shark shark = sharks.poll();
            for(int i = 0; i < shark.speed; i++){
                int nr = shark.r + dr[shark.dir];
                int nc = shark.c + dc[shark.dir];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                    if(shark.dir < 2){
                        shark.dir = (shark.dir+1)%2;
                    }
                    else{
                        shark.dir = 2 + (shark.dir+1)%2;
                    }
                    shark.r += dr[shark.dir];
                    shark.c += dc[shark.dir];
                    continue;
                }

                shark.r = nr;
                shark.c = nc;
            }
            if(map[shark.r][shark.c] != null){
                if(map[shark.r][shark.c].size < shark.size){
                    map[shark.r][shark.c] = shark;
                }
            }
            else{
                map[shark.r][shark.c] = shark;
            }
        }

    }



}


class Shark{
    int r, c, speed, dir, size;

    public Shark(int r, int c, int s, int d, int z){
        this.r = r;
        this.c = c;
        this.dir = d;
        this.speed = s;
        this.size = z;
    }

}