import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, String> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            String tmp = br.readLine();
            hashMap.put(Integer.toString(i), tmp);
            hashMap.put(tmp, Integer.toString(i));
        }
        while(m-- > 0){
            System.out.println(hashMap.get(br.readLine()));
        }
    }
}