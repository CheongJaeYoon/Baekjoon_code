import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;
import java.util.concurrent.Flow.Subscriber;

public class Main {
    public static int[][] graph;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(graph[i], 0);
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i< n; i++){
            sum = 0;
            for(int j = 0; j < n; j++){
                if(j == i)
                    continue;
                sum += bfs(i, j, n);
            }
            if(sum < min){
                min = sum;
                result = i;
            }
        }
        System.out.println(result + 1);
    }

    public static int bfs(int start_node, int end_node, int node_num){
        int[] visited = new int[node_num];
        Arrays.fill(visited, 0);
        visited[start_node] = 1;
        Queue<int []> queue = new LinkedList<>();
        int[] ele = {start_node, 0};
        queue.add(ele);
        while(queue.size() != 0){
            int[] tmp = queue.poll();
            int node = tmp[0];
            int cnt = tmp[1];
            for(int i = 0; i < node_num; i++){
                if(i == node)
                    continue;
                if(graph[node][i] == 1 && visited[i] == 0){
                    visited[i] = 1;
                    if(i == end_node){
                        return cnt + 1;
                    }
                    else{
                        int[] tmp_ele = {i, cnt + 1};
                        queue.add(tmp_ele);
                    }
                }
            }
        }
        return -1;
    }
}