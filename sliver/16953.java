import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;
import java.util.concurrent.Flow.Subscriber;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{a, 1});

        while(!queue.isEmpty()){
            long num = queue.peek()[0];
            long cnt = queue.poll()[1];
            boolean flag = false;
            for(int i = 0; i < 2; i++){
                long tmp = 0;
                if(i == 0){
                    tmp = num * 2;
                }
                else if(i == 1){
                    tmp = num * 10 + 1;
                }

                if(tmp == b){
                    flag = true;
                }
                else if(tmp < b){
                    queue.add(new long[]{tmp, cnt+1});
                }
            }
            if(flag == true){
                System.out.println(cnt+1);
                return;
            }
        }
        System.out.println(-1);
    }
}