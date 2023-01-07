import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static ArrayList<ArrayList<int[]>> graph;
    public static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int j = 0; j < n+1; j++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, c});
        }
        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startNode, endNode));
    }

    public static int dijkstra(int startNode, int endNode){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[]o2){
                return o1[1]-o2[1];
            }
        });
        pQueue.add(new int[]{startNode, 0});
        while(!pQueue.isEmpty()){
            int node = pQueue.peek()[0];
            int cost = pQueue.poll()[1];

            if(cost > dist[node])
                continue;
            
            for(int i = 0; i < graph.get(node).size(); i++){
                int nextNode = graph.get(node).get(i)[0];
                int nextCost = cost + graph.get(node).get(i)[1];
                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pQueue.add(new int[]{nextNode, nextCost});
                }
            }
        }
        return dist[endNode];
    }
}