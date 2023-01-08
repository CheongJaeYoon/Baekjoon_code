import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> queue = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char tmp = str.charAt(i);
            if(tmp == '+' || tmp == '-'){
                if(queue.isEmpty()){
                    queue.add(tmp);
                }
                else{
                    while(!queue.isEmpty()){
                        if(queue.peek() == '('){
                            break;
                        }
                        System.out.print(queue.pop());
                    }
                    queue.add(tmp);
                }
            }
            else if(tmp == '*' || tmp == '/'){
                if(queue.isEmpty()){
                    queue.add(tmp);
                }
                else{
                    while(!queue.isEmpty()){
                        if(queue.peek() == '(' || queue.peek() == '-' || queue.peek() == '+'){
                            break;
                        }
                        System.out.print(queue.pop());
                    }
                    queue.add(tmp);
                }
            }
            else if(tmp == '('){
                queue.add(tmp);
            }
            else if(tmp == ')'){
                while(!(queue.peek() == '(')){
                    System.out.print(queue.pop());
                }
                queue.pop();
            }
            else{
                System.out.print(tmp);
            }
        }
        while(!queue.isEmpty()){
            System.out.print(queue.pop());
        }

    }
}