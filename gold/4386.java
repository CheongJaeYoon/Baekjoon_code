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
            points[i] = new Point(i, Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
        }
        
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                edges.add(new Edge(i, j, Math.sqrt(Math.pow((points[i].x - points[j].x),2) + Math.pow((points[i].y - points[j].y),2))));
            }
        }

        Collections.sort(edges);

        double ans = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge edge = edges.get(i);

			if (uf.find(edge.s) != uf.find(edge.e)) {
				ans += edge.w;
				uf.union(edge.s, edge.e);
			}
		}
        System.out.printf("%.2f", ans);
    }
}

class Point{
    int num;
    double x, y;
    public Point(int num, double x, double y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge>{
    int s, e;
    double w;
    public Edge(int s, int e, double w){
        this.s = s;
        this.e = e;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
        if(this.w - o.w < 0) return -1;
        else return 1;
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