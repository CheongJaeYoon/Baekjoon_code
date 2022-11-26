import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    queue.add(new int[]{i, j});
                }
            }
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            Queue<int[]> next_q = new LinkedList<>();
            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                if(tmp[0] > 0){
                    if(arr[tmp[0]-1][tmp[1]] == 0){
                        arr[tmp[0]-1][tmp[1]] = 1;
                        next_q.add(new int[]{tmp[0]-1, tmp[1]});
                    }
                }
                if(tmp[0] < n-1){
                    if(arr[tmp[0]+1][tmp[1]] == 0){
                        arr[tmp[0]+1][tmp[1]] = 1;
                        next_q.add(new int[]{tmp[0]+1, tmp[1]});
                    }
                }
                if(tmp[1] > 0){
                    if(arr[tmp[0]][tmp[1]-1] == 0){
                        arr[tmp[0]][tmp[1]-1] = 1;
                        next_q.add(new int[]{tmp[0], tmp[1]-1});
                    }
                }
                if(tmp[1] < m-1){
                    if(arr[tmp[0]][tmp[1]+1] == 0){
                        arr[tmp[0]][tmp[1]+1] = 1;
                        next_q.add(new int[]{tmp[0], tmp[1]+1});
                    }
                }
            }
            queue = next_q;
            cnt++;
        }
        cnt--;
        boolean isNotAll = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 0){
                    isNotAll = true;
                    break;
                }
            }
            if(isNotAll)
            break;
        }
        if(isNotAll){
            System.out.println(-1);
        }
        else{
            System.out.println(cnt);
        }
    }
}