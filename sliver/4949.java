import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int i;
        char c;
        Stack<Integer> stack = new Stack<>();
        boolean incorrect = false;
        while(true){
            str = br.readLine();
            if(str.equals("."))
                break;
            stack = new Stack<>();
            incorrect = false;
            for(i=0; i < str.length(); i++){
                c = str.charAt(i);
                if(c == '('){
                    stack.push(0);
                }else if(c == '{'){
                    stack.push(1);
                }else if(c == '['){
                    stack.push(2);
                }else if(c == ')'){
                    if(stack.isEmpty()){
                        incorrect = true;
                        break;
                    }
                    if(stack.pop() != 0){
                        incorrect = true;
                        break;
                    }
                }else if(c == '}'){
                    if(stack.isEmpty()){
                        incorrect = true;
                        break;
                    }
                    if(stack.pop() != 1){
                        incorrect = true;
                        break;
                    }
                }else if(c == ']'){
                    if(stack.isEmpty()){
                        incorrect = true;
                        break;
                    }
                    if(stack.pop() != 2){
                        incorrect = true;
                        break;
                    }
                }
                else if(c == '.'){
                    break;
                }

            }
            if(!stack.isEmpty()){
                incorrect = true;
            }
            if(incorrect){
                System.out.println("no");
            }
            else{
                System.out.println("yes");
            }
        }

    }
}