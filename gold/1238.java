import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static ArrayList<ArrayList<ArrayList<int[]>>> tree;
    public static int n, m, x;
    public static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for(int i = 0; i <2; i++){
            ArrayList<ArrayList<int[]>> tmp = new ArrayList<>();
            for(int j = 0; j < n+1; j++){
                tmp.add(new ArrayList<>());
            }
            tree.add(tmp);
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(0).get(s).add(new int[]{e, c});
            tree.get(1).get(e).add(new int[]{s, c}); // reverse
        }

        dist = new int[2][n+1];
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        Arrays.fill(dist[1], Integer.MAX_VALUE);
        dijkstra(x, 1);
        dijkstra(x, 0);

        int res = 0;
        for(int i = 1; i < n+1; i++){
            res = Math.max(res, dist[0][i] + dist[1][i]);
        }
        System.out.println(res);
    }

    public static void dijkstra(int startNode, int type){
        dist[type][startNode] = 0;
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

            if(cost > dist[type][node])
                continue;
            
            for(int i = 0; i < tree.get(type).get(node).size(); i++){
                int nextNode = tree.get(type).get(node).get(i)[0];
                int nextCost = cost + tree.get(type).get(node).get(i)[1];
                if(nextCost < dist[type][nextNode]){
                    dist[type][nextNode] = nextCost;
                    pQueue.add(new int[]{nextNode, nextCost});
                }
            }
        }
    }
}