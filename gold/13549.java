import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n >= k){
            System.out.println((n-k));
        }
        else{
            boolean[] visited = new boolean[100001];
            Arrays.fill(visited, false);
            Queue<int[]> queue = new LinkedList<>();
            int res = Integer.MAX_VALUE;
            queue.add(new int[]{n, 0});
            while(!queue.isEmpty()){
                int cur = queue.peek()[0];
                int cnt = queue.poll()[1];
                if(cur == k){
                    res = Math.min(cnt, res);
                }
                for(int i = 0; i < 3; i++){
                    int tmp = cur;
                    if(i == 0) tmp*=2;
                    if(i == 1) tmp--;
                    if(i == 2) tmp++;
                    if(0 > tmp || tmp > 100000) continue;
                    if(visited[tmp] == false){
                        visited[tmp] = true;
                        if(i == 1 || i == 2){
                            queue.add(new int[]{tmp, cnt+1});
                        }
                        else{
                            queue.add(new int[]{tmp, cnt});
                        }
                    }
                }
            }
            System.out.println(res);

        }
    }
}