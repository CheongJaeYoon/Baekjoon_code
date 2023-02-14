import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            // 변수 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n  = Integer.parseInt(st.nextToken());
            int k  = Integer.parseInt(st.nextToken());

            int[] delay = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                delay[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
            int[] indegree = new int[n+1];
            for(int i = 0; i <= n; i++){
                tree.add(new ArrayList<>());
            }
            while(k-- > 0){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                tree.get(s).add(e);
                indegree[e]++;
            }

            int w = Integer.parseInt(br.readLine());


            // 실행
            int[] totalCost = new int[n+1];
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 1; i <= n; i++){
                if(indegree[i] == 0){
                    totalCost[i] = delay[i];
                    queue.add(i);
                }
            }
            while(!queue.isEmpty()){
                int now = queue.poll();
                for(int i = 0; i < tree.get(now).size(); i++){
                    int next = tree.get(now).get(i);
                    totalCost[next] = Math.max(totalCost[now] + delay[next], totalCost[next]);
                    indegree[next]--;
                    if(indegree[next] == 0){
                        queue.add(next);
                    }
                }
            }


            //결과
            System.out.println(totalCost[w]);
        }
    }
}