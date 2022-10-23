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
        Stack<Integer> myStack = new Stack<>();
        String operation;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            operation = st.nextToken();
            if(operation.equals("push")){
                myStack.push(Integer.parseInt(st.nextToken()));
            }
            else if(operation.equals("pop")){
                if(myStack.empty())
                    System.out.println("-1");
                else
                    System.out.println(myStack.pop());
            }
            else if(operation.equals("size")){
                System.out.println(myStack.size());
            }
            else if(operation.equals("empty")){
                if(myStack.empty())
                    System.out.println("1");
                else
                    System.out.println("0");
                
            }
            else if(operation.equals("top")){
                if(myStack.empty())
                    System.out.println("-1");
                else
                    System.out.println(myStack.peek());
            }
            else{
                System.out.println("error");;
            }
        }

    }


}