import java.util.*;
import java.util.concurrent.Flow.Subscriber;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] gems = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gems[i][0] = m;
            gems[i][1] = v;
        }

        Arrays.sort(gems, (o1, o2)->o1[0]-o2[0]);
        /*
        for(int i = 0;i < n; i++){
            System.out.println(gems[i][0] + " " + gems[i][1]);
        }
        */

        int[] bags = new int[k];
        for(int i = 0; i < k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        long sum = 0;
        int cnt = 0;
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for(int i = 0; i < k; i++){
            while(cnt < n && (gems[cnt][0] <= bags[i])){
                pQueue.add(gems[cnt].clone());
                cnt++;
            }
            if(!pQueue.isEmpty()){
                sum += pQueue.poll()[1];
            }
        }
        System.out.println(sum);
    }
}