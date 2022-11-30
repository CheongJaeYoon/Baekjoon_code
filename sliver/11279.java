import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        while(t-- > 0){
            long num = Long.parseLong(br.readLine());
            if(num == 0){
                if(pQueue.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(pQueue.poll());
                }
            }
            else{
                pQueue.add(num);
            }
        }
    }
}