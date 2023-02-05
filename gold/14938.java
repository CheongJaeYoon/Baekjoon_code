import java.util.*;
import java.io.*;

public class Main {
	static int n, m, r;
    static int[] item;
    static ArrayList<ArrayList<int[]>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        item = new int[n+1];
        for(int i = 1; i<= n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<int[]>());
        }
        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a, b, l;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, l});
            graph.get(b).add(new int[]{a, l});
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            int tmp = get_item(i);
            max = max < tmp ? tmp : max;
        }
        System.out.println(max);
        
	}
    public static int get_item(int area){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[area] = 0;
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((x, y) -> { return x[1] - y[1]; });
        pQueue.add(new int[]{area, 0});
        while(!pQueue.isEmpty()){
            int cArea = pQueue.peek()[0];
            int cCost = pQueue.poll()[1];

            if(cCost > dist[cArea])
                continue;
            
            for(int i = 0; i < graph.get(cArea).size(); i++){
                int nArea = graph.get(cArea).get(i)[0];
                int nCost = graph.get(cArea).get(i)[1] + cCost;
                if(dist[nArea] > nCost){
                    dist[nArea] = nCost;
                    pQueue.add(new int[]{nArea, nCost});
                }
            }
        }

        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] <= m){
                sum += item[i];
            }
        }
        return sum;
    }
}