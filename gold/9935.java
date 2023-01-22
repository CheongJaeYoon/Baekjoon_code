import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int slen = str.length();
        String boom = br.readLine();
        int blen = boom.length();

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < slen; i++){
            stack.push(str.charAt(i));

            if(stack.size() >= blen){

                boolean flag = true;
                int ssize = stack.size();

                for(int j = 0; j < blen; j++){
                    if(stack.get(ssize - blen + j) != boom.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if(flag == true){
                    for(int j = 0; j < blen; j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(Character c : stack){
            sb.append(c);
        }
        if(sb.length() == 0){
            System.out.println("FRULA");
        }
        else{
            System.out.println(sb.toString());
        }
    }
}