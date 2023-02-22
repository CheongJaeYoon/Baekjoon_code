import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static PriorityQueue<int[]> edge;
    public static int[] parent;
    public static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edge = new PriorityQueue<>((x, y) -> { return x[2] - y[2]; });
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edge.add(new int[]{a, b, c});
        }
        
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }


        int sum = 0;
        int last = 0;
        while(!edge.isEmpty()){
            int[] tmp = edge.poll();
            if(find(tmp[0]) != find(tmp[1])){
                last = tmp[2];
                sum += tmp[2];
                union(tmp[0], tmp[1]);
            }
        }

        System.out.println(sum - last);
    }

    public static int find(int v){
        if(parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    public static void union(int v1, int v2){
        v1 = find(v1);
        v2 = find(v2);
        if(v1 != v2)
            parent[v2] = v1;
    }
}