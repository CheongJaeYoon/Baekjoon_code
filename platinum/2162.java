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
        Line[] lines = new Line[n];
        for(int i = 0; i < n;i++){
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(lines[i].isIntersect(lines[j])){
                    uf.union(i, j);
                }
            }
        }

        int cnt = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            if(uf.parents[i] < 0){
                cnt++;
                max = Math.max(max, -uf.parents[i]);
            }
        }
        System.out.println(cnt + "\n" + max);
    }
}

class Point implements Comparable<Point>{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x){
            return this.y - o.y;
        }
        else{
            return this.x - o.x;
        }
    }
}

class Line{
    Point p1, p2;
    public Line(Point p1, Point p2){
        if(p1.compareTo(p2) <= 0){
            this.p1 = p1;
            this.p2 = p2;
        }
        else{
            this.p1 = p2;
            this.p2 = p1;
        }
    }
    public Line(int x1, int y1, int x2, int y2){
        this(new Point(x1, y1), new Point(x2, y2));
    }

    private int ccw(Point a, Point b, Point c){
        long sum = (b.x-a.x)*(c.y-a.y)-(b.y-a.y)*(c.x-a.x);
        if(sum > 0) return 1;
        if(sum < 0) return -1;
        return 0;
    }

    public boolean isIntersect(Line o){
        int tmp1 = ccw(this.p1, this.p2, o.p1);
        int tmp2 = ccw(this.p1, this.p2, o.p2);
        int tmp3 = ccw(o.p1, o.p2, this.p1);
        int tmp4 = ccw(o.p1, o.p2, this.p2);

        if((tmp1 != tmp2) && (tmp3 != tmp4)){
            return true;
        }
        else if((tmp1 == 0) && (tmp2 == 0) && (tmp3 == 0) && (tmp4 == 0)){
            if((this.p1.compareTo(o.p2) <= 0) && (this.p2.compareTo(o.p1) >= 0)){
                return true;
            }
        }
        return false;
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