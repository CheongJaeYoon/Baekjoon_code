import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static int n;
    public static int[][] arr;
    public static int[] visited;
    public static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new int[n+1];
        cnt = 0;
        Arrays.fill(visited, 0);
        for(int i = 0; i < n+1; i++){
            Arrays.fill(arr[i], 0);
        }
        int k = Integer.parseInt(br.readLine());
        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(cnt  - 1);
    }
    public static void dfs(int node){
        visited[node] = 1;
        cnt++;
        for(int i = 1; i < n+1; i++){
            if(arr[node][i] == 1){
                if(visited[i] == 0){
                    dfs(i);
                }
            }
        }
    }
}