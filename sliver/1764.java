import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hash = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        int cnt = 0;

        while(n-- > 0){
            hash.put(br.readLine(), 1);
        }
        while(m-- > 0){
            String tmp = br.readLine();
            if(hash.containsKey(tmp)){
                arr.add(tmp);
                cnt++;
            }
        }
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(cnt);
        for(int i = 0; i < cnt; i++){
            System.out.println(arr.get(i));
        }

    }
}