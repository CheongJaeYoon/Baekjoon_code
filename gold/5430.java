import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            String OpCodes = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String str = br.readLine();
            String[] tmp = str.substring(1, str.length()-1).split(",");
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 0; i < n; i++){
                deque.add(Integer.parseInt(tmp[i]));
            }
            boolean reverse = false;
            boolean error = false;

            for(int i = 0; i < OpCodes.length(); i++){
                char OpCode = OpCodes.charAt(i);
                if(OpCode == 'R'){
                    reverse = !reverse;
                }
                else if(OpCode == 'D'){
                    if(deque.isEmpty()){
                        error = true;
                        break;
                    }
                    if(reverse){
                        deque.pollLast();
                    }
                    else{
                        deque.pollFirst();
                    }
                }
            }

            if(error){
                sb.append("error\n");
            }
            else{
                sb.append("[");
                if(deque.size() != 0){
                    if(reverse){
                        sb.append(deque.pollLast());
                        while(!deque.isEmpty()){
                            sb.append("," + deque.pollLast());
                        }
                    }
                    else{
                        sb.append(deque.pollFirst());
                        while(!deque.isEmpty()){
                            sb.append("," + deque.pollFirst());
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        if(sb.length() != 0){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }
}