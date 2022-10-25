import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> myDeque = new LinkedList<>();
        String operation;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken();
            if(operation.equals("push_front")){
                myDeque.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if(operation.equals("push_back")){
                myDeque.addLast(Integer.parseInt(st.nextToken()));
            }
            else if(operation.equals("pop_front")){
                if(myDeque.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(myDeque.pollFirst());
            }
            else if(operation.equals("pop_back")){
                if(myDeque.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(myDeque.pollLast());
            }
            else if(operation.equals("size")){
                System.out.println(myDeque.size());
            }
            else if(operation.equals("empty")){
                if(myDeque.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
                
            }
            else if(operation.equals("front")){
                if(myDeque.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(myDeque.peekFirst());
            }
            else if(operation.equals("back")){
                if(myDeque.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(myDeque.peekLast());
            }
            else{
                System.out.println("error");;
            }
        }

    }


}