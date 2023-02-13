import java.util.*;
import java.io.*;

public class Main {
	static int[][] room;
	static int r, c, a_r, a_c;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        room = new int[r][c];
        cnt = 0;
        boolean flag = false;
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
                if(room[i][j] == -1 && flag == false){
                    a_r = i;
                    a_c = j;
                    flag = true;
                }
            }
        }

        while(t-- > 0){
            simulate();
        }

        int sum = 0;
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int tmp = room[i][j];
                if(tmp > 0){
                    sum += tmp;
                }
                
            }
        }

        System.out.println(sum);
	}

	private static void simulate() {
        int[][] tmp = new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int unit = room[i][j]/5;
                int middle = room[i][j];
                if(i > 0 && room[i-1][j] != -1){
                    tmp[i-1][j] += unit;
                    middle -= unit;
                }
                if(j < c - 1 && room[i][j+1] != -1){
                    tmp[i][j+1] += unit;
                    middle -= unit;
                }
                if(i < r - 1 && room[i+1][j] != -1){
                    tmp[i+1][j] += unit;
                    middle -= unit;
                }
                if(j > 0 && room[i][j-1] != -1){
                    tmp[i][j-1] += unit;
                    middle -= unit;
                }
                tmp[i][j] += middle;
            }
        }

        //위
        for (int i = a_r - 1; i > 0; i--) {
            tmp[i][0] = tmp[i-1][0];
        }
        for (int i = 0; i < c - 1; i++){
            tmp[0][i] = tmp[0][i+1];
        }
        for (int i = 0; i < a_r; i++){
            tmp[i][c - 1] = tmp[i + 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--){
            tmp[a_r][i] = tmp[a_r][i-1];
        }
        tmp[a_r][1] = 0;
        //아래
        for (int i = a_r + 2; i < r - 1; i++){
            tmp[i][0] = tmp[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++){
            tmp[r - 1][i] = tmp[r - 1][i + 1]; 
        }
        for (int i = r - 1; i > a_r+1; i--){
            tmp[i][c - 1] = tmp[i - 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--){
            tmp[a_r+1][i] = tmp[a_r+1][i - 1];
        }
        tmp[a_r+1][1] = 0;

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                room[i][j] = tmp[i][j];
            }
        }
	}

}