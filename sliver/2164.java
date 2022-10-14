import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            cards.add(i);
        }
        boolean is_remove = true;
        int tmp;
        while(cards.size() != 1){
            if(is_remove){
                cards.remove();
            }
            else{
                cards.add(cards.poll());
            }
            is_remove = !is_remove;
        }
        System.out.println(cards.poll());
    }


}