import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Dot> dots = new ArrayList<>();
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots.add(new Dot(x, y));
        }
        Collections.sort(dots, new Comparator<Dot>() {
            @Override
            public int compare(Dot a, Dot b){
                if(a.getX() == b.getX()){
                    return a.getY() - b.getY();
                }
                else{
                    return a.getX() - b.getX();
                }
            }
            
        });
        for(Dot tmp : dots){
            System.out.println(tmp.getX() + " " + tmp.getY());
        }

    }


}

class Dot{
    private int x;
    private int y;
    public Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}