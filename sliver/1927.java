import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder("");
        while(n-- > 0){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                if(priorityQueue.isEmpty()){
                    sb.append(tmp + "\n");
                }
                else{
                    sb.append(priorityQueue.poll() + "\n");
                }
            }
            else{
                priorityQueue.add(tmp);
            }
        }
        System.out.println(sb.toString());
    }
}