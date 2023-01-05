import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static ArrayList<ArrayList<int[]>> tree;
    public static int v, e;
    public static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for(int j = 0; j < v+1; j++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(s).add(new int[]{e, c});
        }

        dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(startNode);
        for(int i = 1; i < v+1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int startNode){
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
            
            for(int i = 0; i < tree.get(node).size(); i++){
                int nextNode = tree.get(node).get(i)[0];
                int nextCost = cost + tree.get(node).get(i)[1];
                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pQueue.add(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}