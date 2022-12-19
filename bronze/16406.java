import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] mine = br.readLine().split("");
        String[] friend = br.readLine().split("");
        int same = 0;
        int diff = 0;
        
        for(int i = 0; i < mine.length; i++){
            if(mine[i].equals(friend[i])){
                same++;
            }
            else{
                diff++;
            }
        }
        if(same >= k){
            System.out.println(k + diff);
        }
        if(same < k){
            System.out.println(same + (diff-(k-same)));
        }
    }
}