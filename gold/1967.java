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
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            tree.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(s).add(new int[]{e, c});
            tree.get(e).add(new int[]{s, c});
        }

        visited = new boolean[n+1];
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