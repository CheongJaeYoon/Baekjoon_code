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
        Queue<Integer> myQueue = new LinkedList<>();
        String operation;
        int back = -1;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken();
            if(operation.equals("push")){
                back = Integer.parseInt(st.nextToken());
                myQueue.add(back);
            }
            else if(operation.equals("pop")){
                if(myQueue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(myQueue.poll());
            }
            else if(operation.equals("size")){
                System.out.println(myQueue.size());
            }
            else if(operation.equals("empty")){
                if(myQueue.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
                
            }
            else if(operation.equals("front")){
                if(myQueue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(myQueue.peek());
            }
            else if(operation.equals("back")){
                if(myQueue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(back);
            }
            else{
                System.out.println("error");;
            }
        }

    }


}