import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static ArrayList<int[]> edge;
    public static int n;
    public static int[] dist;
    public static final int INF = 2000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            edge = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist = new int[n+1];
            Arrays.fill(dist, INF);

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edge.add(new int[]{s, e, t});
                edge.add(new int[]{e, s, t});
            }
            for(int i = 0; i < w; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edge.add(new int[]{s, e, -t});
            }
            if(bellmanFord(1) == true){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }

    public static boolean bellmanFord(int startNode){
        dist[startNode] = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < edge.size(); j++){
                int[] tmp = edge.get(j);
                if(dist[tmp[1]] > dist[tmp[0]] + tmp[2]){ // INF로 방문확인 하지 않는 이유 - 음의 사이클이 존재하는지만 알면 되므로
                    dist[tmp[1]] = dist[tmp[0]] + tmp[2];
                    if(i == n-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}