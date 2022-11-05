import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        int tmp;
        while(n-- > 0){
            tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                stack.pop();
            }
            else{
                stack.push(tmp);
            }
        }
        n = stack.size();
        int sum = 0;
        while(n-- > 0){
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
