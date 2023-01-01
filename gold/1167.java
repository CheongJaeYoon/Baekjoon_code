import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static ArrayList<ArrayList<int[]>> tree;
    public static boolean[] visited;
    public static int totalDist = -1;
    public static int startNode = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int v = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0; i < v+1; i++){
            tree.add(null);
        }
        for(int i = 0; i < v; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            ArrayList<int[]> element = new ArrayList<>();
            while(true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1){
                    break;
                }
                int line = Integer.parseInt(st.nextToken());
                element.add(new int[]{tmp, line});
            }
            tree.set(idx, element);
        }

        visited = new boolean[v+1];
        Arrays.fill(visited, false);
        dfs(1, 0);
        Arrays.fill(visited, false);
        totalDist = -1;
        dfs(startNode, 0);
        System.out.println(totalDist);
        

    }

    public static void dfs(int node, int distance){
        visited[node] = true;

        if(totalDist < distance){
            totalDist = distance;
            startNode = node;
        }
        for(int i = 0; i < tree.get(node).size(); i++){
            int nextNode = tree.get(node).get(i)[0];
            int nextDist = tree.get(node).get(i)[1];
            if(visited[nextNode] == false){
                dfs(nextNode, distance + nextDist);
            }
        }
    }
}