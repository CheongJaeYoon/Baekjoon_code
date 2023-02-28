import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        long[] b = new long[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Long> sum_a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            long sum = 0;
            for(int j = i; j < n; j++){
                sum += a[j];
                sum_a.add(sum);
            }
        }
        
        ArrayList<Long> sum_b = new ArrayList<>();
        for(int i = 0; i < m; i++){
            long sum = 0;
            for(int j = i; j < m; j++){
                sum += b[j];
                sum_b.add(sum);
            }
        }

        Collections.sort(sum_a);
        Collections.sort(sum_b);

        int l = 0;
        int r = sum_b.size() - 1;
        long cnt = 0;

        while(l < sum_a.size() && r >= 0){
            long sum = sum_a.get(l) + sum_b.get(r);

            if( sum == t){

                long tmp_a = sum_a.get(l);
                long tmp_b = sum_b.get(r);
                long cnt_a = 0;
                long cnt_b = 0;
                while(l < sum_a.size() && sum_a.get(l) == tmp_a){
                    cnt_a++;
                    l++;
                }
                while(r >= 0 && sum_b.get(r) == tmp_b){
                    cnt_b++;
                    r--;
                }

                cnt += cnt_a * cnt_b;

            }
            else if(sum < t){
                l++;
            }
            else{
                r--;
            }
        }

        System.out.println(cnt);
    }
}