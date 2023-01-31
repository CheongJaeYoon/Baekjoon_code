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
            System.out.println((n-k) + "\n1");
            return;
        }
        else{
            Queue<Integer> queue = new LinkedList<>();
            int[] time = new int[100001];
            int min = Integer.MAX_VALUE;
            int cnt = 0;

            
            queue.add(n);
            time[n] = 1;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                if(time[cur] > min){
                    break;
                }

                for(int i = 0; i < 3; i++){
                    int next = cur;

                    if(i == 0){
                        next--;
                    }
                    else if(i == 1){
                        next++;
                    }
                    else{
                        next *= 2;
                    }

                    if( next < 0 || 100000 < next){
                        continue;
                    }

                    if(next == k){
                        min = time[cur];
                        cnt++;
                    }

                    if(time[next] == 0 || time[next] == time[cur]+1){
                        queue.add(next);
                        time[next] = time[cur] + 1;
                    }

                }
            }

            System.out.println(min + "\n" + cnt);
        }
    }
}