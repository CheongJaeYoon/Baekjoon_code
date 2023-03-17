import java.util.*;
import java.beans.Visibility;
import java.io.*;
import java.lang.Math;

public class Main{
    public static UnionFind uf;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        uf = new UnionFind(g+1);
        int p = Integer.parseInt(br.readLine());
        int cnt = 0;
        boolean flag = false;
        while(p-- > 0){
            int gi = Integer.parseInt(br.readLine());

            if(flag == true) continue;
            

            int tmp = uf.find(gi);
            if(tmp == 0){
                flag = true;
                continue;
            }

            cnt++;
            uf.union(tmp, tmp - 1);


        }
        System.out.println(cnt);

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
            parents[a] = b;
        }
        
    }
}