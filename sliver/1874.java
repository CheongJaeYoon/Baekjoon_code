import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int tmp;
        int cur_num = 0;
        boolean error = false;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++){
            tmp = Integer.parseInt(br.readLine());
            while(true){
                if(cur_num < tmp){   
                    cur_num++;
                    stack.push(cur_num);
                    sb.append("+\n");
                }
                else{
                    if(stack.pop() == tmp){
                        sb.append("-\n");
                        break;
                    }
                    else{
                        error = true;
                        break;
                    }
                }
            }
            if(error)
                break;
        }
        if(error){
            System.out.println("NO");
        }
        else{
            System.out.println(sb.toString());
        }
    }
}