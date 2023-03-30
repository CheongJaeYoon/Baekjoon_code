import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char map[][] = new char[n][m];
        int group[][] = new int[n][m];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            map[i] = br.readLine().toCharArray();
        }

        int[] dr = new int[]{ 1, -1, 0,  0};
        int[] dc = new int[]{ 0,  0, 1, -1};
        int idx = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(group[i][j] == 0 && map[i][j] == '0'){
                    int cnt = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    group[i][j] = idx;
                    while(!queue.isEmpty()){
                        int r = queue.peek()[0];
                        int c = queue.poll()[1];
                        for(int k = 0; k < 4; k++){
                            int nr = r + dr[k];
                            int nc = c + dc[k];
                            if( 0 <= nr && 0 <= nc && nr < n && nc < m){
                                if(map[nr][nc] == '0' && group[nr][nc] == 0){
                                    group[nr][nc] = idx;
                                    cnt++;
                                    queue.add(new int[]{nr, nc});
                                }
                            }
                        }
                    }
                    hm.put(idx,cnt);
                    idx++;
                }

            }
        }

        HashSet<Integer> hs;
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                int sum = 1;
                hs = new HashSet<>();
                if(map[r][c] == '1'){
                    for(int k = 0; k < 4; k++){
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        if( 0 <= nr && 0 <= nc && nr < n && nc < m && map[nr][nc] == '0'){
                            hs.add(group[nr][nc]);
                        }
                    }
                    for(int i : hs){
                        sum += (hm.get(i));
                    }
                    sb.append(sum%10);
                }
                else{
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}