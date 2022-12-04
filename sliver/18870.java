import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.io.*;
import java.math.BigInteger;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> ranking = new HashMap<>();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            pQueue.add(num);
        }
        int idx = 0;
        int pre = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int cur = pQueue.poll();
            if(pre != cur){
                ranking.put(cur, idx);
                idx++;
            }
            pre = cur;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ranking.get(arr[0]));
        for(int i = 1; i < n; i++){
            sb.append(" " + ranking.get(arr[i]));
        }
        System.out.println(sb.toString());
    }
}