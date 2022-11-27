import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            StringTokenizer st;
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String opCode = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(opCode.equals("I")){
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                }
                else if(opCode.equals("D")){
                    if(!treeMap.isEmpty()){
                        if(num == 1){
                            num = treeMap.lastKey();
                        }
                        else if(num == -1){
                            num = treeMap.firstKey();
                        }
                        if(treeMap.put(num, treeMap.get(num) - 1) == 1){
                            treeMap.remove(num);
                        }
                    }
                }
            }
            if(treeMap.isEmpty()){
                System.out.println("EMPTY");
            }
            else{
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }
}