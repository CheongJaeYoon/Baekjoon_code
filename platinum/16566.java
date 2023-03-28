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
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[m];
        for(int i = 0; i < m; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        uf = new UnionFind(m+1);
        StringBuilder sb = new StringBuilder();
        int input = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            input = Integer.parseInt(st.nextToken());
            int idx = Arrays.binarySearch(cards, input+1);
            idx = idx < 0? -(idx+1) : idx;
            idx = uf.find(idx);
            sb.append(cards[idx] + "\n");
            uf.union(idx, idx+1);
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
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