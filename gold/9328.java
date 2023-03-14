import java.io.*;
import java.util.*;

import javax.lang.model.element.Element;

import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cnt = 0;
            boolean[][] visited = new boolean[h+2][w+2];
            boolean[] keys = new boolean[26];
            ArrayList<ArrayList<int[]>> gate = new ArrayList<>(); 
            char[][] map = new char[h+2][w+2];

            for(int i = 0; i < 26; i++){
                gate.add(new ArrayList<>());
            }

            for(int i = 0; i < h+2; i++){
                for(int j = 0; j < w+2; j++){
                    map[i][j] = '.';
                }
            }

            for(int i = 0; i < h; i++){
                String str = br.readLine();
                for(int j = 0; j < w; j++){
                    map[i+1][j+1] = str.charAt(j);
                }
            }

            String str = br.readLine();
            if(!str.equals("0")){
                for(int i = 0; i < str.length(); i++){
                    keys[str.charAt(i) - 'a'] = true;
                }
            }


            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            visited[0][0] = true;
            while(!queue.isEmpty()){
                int c_x = queue.peek()[0];
                int c_y = queue.poll()[1];
                for(int i = 0; i < 4; i++){
                    int x = c_x + dx[i];
                    int y = c_y + dy[i];

                    if(x < 0 || y < 0 || x >= h+2 || y >= w+2) continue;

                    if(map[x][y] == '*' || visited[x][y] == true) continue;

                    char state = map[x][y];

                    if(state >= 'A' && state <= 'Z'){
                        if(keys[state - 'A'] == true){
                            map[x][y] = '.';
                            visited[x][y] = true;
                            queue.add(new int[]{x, y});
                        }
                        else{
                            gate.get(state - 'A').add(new int[]{x, y});
                        }
                    }
                    else if(state >= 'a' && state <= 'z'){
                        keys[state - 'a'] = true;
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                        for(int k = 0; k < 26; k++){
                            if(keys[k] == true && gate.get(k).size() != 0){
                                for(int g = 0; g < gate.get(k).size(); g++){
                                    int g_x = gate.get(k).get(g)[0];
                                    int g_y = gate.get(k).get(g)[1];
                                    map[g_x][g_y] = '.';

                                    visited[g_x][g_y] = true;
                                    queue.add(new int[]{g_x, g_y});
                                }
                            }
                        }
                    }
                    else if(state == '$'){
                        cnt++;
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }
                    else{
                        visited[x][y] = true;
                        queue.add(new int[]{x, y});
                    }

                }
            }

            System.out.println(cnt);
        }
    }
}