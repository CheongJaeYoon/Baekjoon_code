import java.util.*;
import java.util.concurrent.Flow.Subscriber;
import java.io.*;
import java.lang.Math;

public class Main{

    public static ArrayList<Integer> left;
    public static ArrayList<Integer> right;
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        left = new ArrayList<>();
        right = new ArrayList<>();

        subset(0, n/2, 0, 0);
        subset(n/2, n, 0, 1);

        Collections.sort(left);
        Collections.sort(right);

        int pl = 0;
        int pr = right.size() -1;

        long cnt = 0;

        while(pl < left.size() && pr >= 0){

            long sum = left.get(pl) + right.get(pr);

            if(sum == s){
                long tmp = left.get(pl);
                long cnt1 = 0;
                while(pl < left.size() && left.get(pl) == tmp){
                    pl++;
                    cnt1++;
                }
                
                tmp = right.get(pr);
                long cnt2 = 0;
                while(pr >= 0 && right.get(pr) == tmp){
                    pr--;
                    cnt2++;
                }

                cnt += cnt1*cnt2;
            }
            else if(sum < s){
                pl++;
            }
            else{
                pr--;
            }
        }

        if( s == 0){
            cnt--;
        }
        System.out.println(cnt);

    }
    public static void subset(int idx, int end, int sum, int type){
        if(idx == end && type == 0){
            left.add(sum);
            return;
        }
        if(idx == end && type == 1){
            right.add(sum);
            return;
        }
        subset(idx+1, end, sum, type);
        subset(idx+1, end, sum+arr[idx], type);
    }
}