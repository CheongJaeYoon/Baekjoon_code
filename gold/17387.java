import java.util.*;
import java.beans.Visibility;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Line[] lines = new Line[2];
        for(int i = 0; i < 2;i++){
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(lines[0].isIntersect(lines[1])? 1 : 0);
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
