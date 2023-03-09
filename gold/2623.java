import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        int[] indegree = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a;
            int b = Integer.parseInt(st.nextToken());
            for(int i = 1 ; i < t; i++){
                a = b;
                b = Integer.parseInt(st.nextToken());
                tree.get(a).add(b);
                indegree[b]++;
            }
        }

        StringBuilder sb = new StringBuilder("");
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                pQueue.add(i);
            }
        }
        int cnt = 0;
        while(!pQueue.isEmpty()){
            int now = pQueue.poll();
            sb.append(now + "\n");
            cnt++;
            for(int i = 0; i < tree.get(now).size(); i++){
                int next = tree.get(now).get(i);
                indegree[next]--;
                if(indegree[next] == 0){
                    pQueue.add(next);
                }
            }
        }

        if(cnt != n){
            System.out.println("0");
            return;
        }
        
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}