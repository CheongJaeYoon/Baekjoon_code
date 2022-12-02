import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean arr[][] = new boolean[n][n];
        boolean visited[] = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(arr[i], false);
        }
        Arrays.fill(visited, false);

        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            arr[a][b] = true;
            arr[b][a] = true;
        }

        Queue<Integer> queue;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(visited[i] == false){
                cnt++;
                queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while(!queue.isEmpty()){
                    int cur = queue.poll();
                    for(int j = 0; j < n; j++){
                        if(arr[cur][j] == true && visited[j] == false){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}