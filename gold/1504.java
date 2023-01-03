import java.util.*;

import javax.xml.stream.events.EndElement;

import java.io.*;
import java.lang.Math;

public class Main{
    public static ArrayList<ArrayList<int[]>> tree;
    public static int n, e;
    public static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for(int j = 0; j < n+1; j++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(s).add(new int[]{e, c});
            tree.get(e).add(new int[]{s, c}); // reverse
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        int fir = dijkstra(1, v1)+dijkstra(v1, v2)+dijkstra(v2, n);
        int sec = dijkstra(1, v2)+dijkstra(v2, v1)+dijkstra(v1, n);
        System.out.println(Math.min(fir, sec)<0? -1: Math.min(fir, sec));

    }

    public static int dijkstra(int startNode, int endNode){
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
            
            for(int i = 0; i < tree.get(node).size(); i++){
                int nextNode = tree.get(node).get(i)[0];
                int nextCost = cost + tree.get(node).get(i)[1];
                if(nextCost < dist[nextNode]){
                    dist[nextNode] = nextCost;
                    pQueue.add(new int[]{nextNode, nextCost});
                }
            }
        }
        if(dist[endNode] == Integer.MAX_VALUE){
            return Integer.MIN_VALUE;
        }
        else{
            return dist[endNode];
        }
    }
}