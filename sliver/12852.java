import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int idx = now.length - 1;
            if(now[idx] == 1){
                System.out.println(idx);
                for(int i = 0; i < idx; i++){
                    System.out.print(now[i] + " ");
                }
                System.out.print(now[idx]);
                return;
            }
            for(int i = 0; i < 3; i++){
                if(i == 0 && now[idx] % 3 == 0){
                    int[] next = new int[idx+2];
                    for(int j = 0; j < idx+1; j++){
                        next[j] = now[j];
                    }
                    next[idx+1] = now[idx] / 3;
                    queue.add(next);
                }
                if(i == 1 && now[idx] % 2 == 0){
                    int[] next = new int[idx+2];
                    for(int j = 0; j < idx+1; j++){
                        next[j] = now[j];
                    }
                    next[idx+1] = now[idx] / 2;
                    queue.add(next);
                }
                if(i == 2){
                    int[] next = new int[idx+2];
                    for(int j = 0; j < idx+1; j++){
                        next[j] = now[j];
                    }
                    next[idx+1] = now[idx] - 1;
                    queue.add(next);
                }
            }
        }
    }
}