import java.util.*;
import java.beans.Visibility;
import java.io.*;
import java.lang.Math;

public class Main{
    public static UnionFind uf;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        uf = new UnionFind(n);
        Point[] points = new Point[n];
        for(int i = 0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        ArrayList<Edge> edges = new ArrayList<>();

        Arrays.sort(points, (p1, p2) -> p1.x - p2.x);
        for(int i = 0; i < n-1; i++){
            edges.add(new Edge(points[i].num, points[i+1].num, Math.abs(points[i].x - points[i+1].x)));
        }
        
        Arrays.sort(points, (p1, p2) -> p1.y - p2.y);
        for(int i = 0; i < n-1; i++){
            edges.add(new Edge(points[i].num, points[i+1].num, Math.abs(points[i].y - points[i+1].y)));
        }
        
        Arrays.sort(points, (p1, p2) -> p1.z - p2.z);
        for(int i = 0; i < n-1; i++){
            edges.add(new Edge(points[i].num, points[i+1].num, Math.abs(points[i].z - points[i+1].z)));
        }

        Collections.sort(edges);

        int ans = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);

			if (uf.find(edge.s) != uf.find(edge.e)) {
				ans += edge.w;
				uf.union(edge.s, edge.e);
			}
		}
        System.out.println(ans);
    }
}

class Point{
    int num, x, y, z;
    public Point(int num, int x, int y, int z){
        this.num = num;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Edge implements Comparable<Edge>{
    int s, e, w;
    public Edge(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}

class UnionFind{
    int[] parents;

    public UnionFind(int num){
        parents = new int[num];
        Arrays.fill(parents, -1);
    }

    public int find(int a) {
        if(parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b){
            int p, c;
            if(parents[a] < parents[b]){
                p = a;
                c = b;
            }
            else{
                p = b;
                c = a;
            }
            parents[p] += parents[c];
            parents[c] = p;
        }
        
    }
}