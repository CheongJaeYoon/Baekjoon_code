import java.util.*;
import java.beans.Visibility;
import java.io.*;
import java.lang.Math;

public class Main{
    public static UnionFind uf;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] input = new int[m][2];
        uf = new UnionFind(n);

        for(int i = 0; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            int a = uf.find(input[i][0]);
            int b = uf.find(input[i][1]);
            if(a == b){
                System.out.println(i+1);
                return;
            }
            else{
                uf.union(a, b);
            }
        }

        System.out.println(0);

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