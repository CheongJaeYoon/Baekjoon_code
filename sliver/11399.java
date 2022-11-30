import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            pQueue.add(Integer.parseInt(st.nextToken()));
        }
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += pQueue.poll() * (n-i);
        }
        System.out.println(sum);
    }
}