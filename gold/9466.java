import java.io.*;
import java.util.*;
import java.util.concurrent.Flow.Subscriber;
import java.math.*;

public class Main{
    public static ArrayList<Integer> arr;
    public static int[] graph;
    public static boolean[] visited;
    public static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new ArrayList<>();
            graph = new int[n+1];
            for(int i = 1; i < n+1; i++){
                graph[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n+1];
            cnt = 0;
            for(int i = 1; i < n+1; i++){
                if(visited[i] == true){
                    continue;
                }
                else{
                    dfs(i);
                    arr = new ArrayList<>();
                }
            }
            System.out.println(cnt);
        }
    }
    public static void dfs(int n){
        arr.add(n);
        visited[n] = true;

        int next = graph[n];

        if(visited[next] == false){
            dfs(next);
        }
        else{
            boolean flag = true;
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i) == next){
                    flag = false;
                    cnt += i;
                    break;
                }
            }
            if(flag == true){
                cnt += arr.size();
            }
        }
    }
}