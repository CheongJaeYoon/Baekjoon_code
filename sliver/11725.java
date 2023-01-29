import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<Integer>());
        }
        StringTokenizer st;
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a-1).add(b-1);
            tree.get(b-1).add(a-1);
        }

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty() == true){
            int cur = queue.poll();
            ArrayList<Integer> tmp = tree.get(cur);
            for(int i = 0; i < tmp.size(); i++){
                int next = tmp.get(i);
                if(visited[next] == false){
                    queue.add(next);
                    parent[next] = cur;
                    visited[next] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n; i++){
            sb.append(parent[i]+1);
            if(i != n-1){
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}