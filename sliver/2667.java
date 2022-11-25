import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] visited_arr = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(visited_arr[i], 0);
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < n; j++){
                if(tmp[j].equals("1")){
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j] = 0;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        LinkedList<Integer> cnts = new LinkedList<>();

        for(int i = 0; i< n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 1 && visited_arr[i][j]  == 0){
                    int cnt = 0;
                    queue.add(new int[]{i, j});
                    visited_arr[i][j] = 1;
                    cnt++;
                    while(!queue.isEmpty()){
                        int[] tmp = queue.poll();
                        if(tmp[0] > 0){
                            if(visited_arr[tmp[0]-1][tmp[1]] == 0 && arr[tmp[0]-1][tmp[1]] == 1){
                                queue.add(new int[]{tmp[0]-1, tmp[1]});
                                visited_arr[tmp[0]-1][tmp[1]] = 1;
                                cnt++;
                            }
                        }
                        if(tmp[0] < n-1){
                            if(visited_arr[tmp[0]+1][tmp[1]] == 0 && arr[tmp[0]+1][tmp[1]] == 1){
                                queue.add(new int[]{tmp[0]+1, tmp[1]});
                                visited_arr[tmp[0]+1][tmp[1]] = 1;
                                cnt++;
                            }
                        }
                        if(tmp[1] > 0){
                            if(visited_arr[tmp[0]][tmp[1]-1] == 0 && arr[tmp[0]][tmp[1]-1] == 1){
                                queue.add(new int[]{tmp[0], tmp[1]-1});
                                visited_arr[tmp[0]][tmp[1]-1] = 1;
                                cnt++;
                            }
                        }
                        if(tmp[1] < n-1){
                            if(visited_arr[tmp[0]][tmp[1]+1] == 0 && arr[tmp[0]][tmp[1]+1] == 1){
                                queue.add(new int[]{tmp[0], tmp[1]+1});
                                visited_arr[tmp[0]][tmp[1]+1] = 1;
                                cnt++;
                            }
                        }
                    }
                    cnts.add(cnt);
                }
            }
        }
        System.out.println(cnts.size());
        Collections.sort(cnts, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        while(!cnts.isEmpty()){
            System.out.println(cnts.poll());
        }
    }
}