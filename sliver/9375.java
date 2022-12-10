import java.util.*;
import java.io.*;
import java.lang.Math;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(int i = 0 ; i < n; i ++){
                st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String type = st.nextToken();
                hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
            }
            int sum = 1;
            for(Integer value : hashMap.values()){
                sum *= (value+1);
            }
            System.out.println(sum-1);
        }

    }
}