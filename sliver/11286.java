import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        while(n-- > 0){
            int x = Integer.parseInt(br.readLine());
            if(x != 0){
                if(x < 0){
                    pQueue.add(-x);
                    hashmap.put(x, hashmap.getOrDefault(x, 0)+1);
                }
                else{
                    pQueue.add(x);
                    hashmap.put(x, hashmap.getOrDefault(x, 0)+1);
                }
            }
            else{
                if(pQueue.isEmpty()){
                    System.out.println(0);
                }
                else{
                    int tmp = pQueue.poll();
                    if(hashmap.containsKey(-tmp) && hashmap.get(-tmp) > 0){
                        hashmap.put(-tmp, hashmap.get(-tmp)-1);
                        System.out.println(-tmp);
                    }
                    else{
                        hashmap.put(tmp, hashmap.get(tmp)-1);
                        System.out.println(tmp);
                    }
                }
            }

        }
    }
}