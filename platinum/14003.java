import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        int[][] trace = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(arr[0]);
        int cnt = 1;
        trace[0][0] = cnt;
        trace[0][1] = list.get(cnt-1);

        for(int i = 1; i < n; i++){
            int now = arr[i];

            if(list.get(cnt-1) < now){
                list.add(now);
                cnt++;
                trace[i][0] = cnt;
                trace[i][1] = list.get(cnt-1);
            }
            else{
                int tmp = Collections.binarySearch(list, now);
                tmp = tmp < 0? -(tmp+1) : tmp;
                list.set(tmp, now);
                trace[i][0] = tmp + 1;
                trace[i][1] = list.get(tmp);
            }
        }
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        int[] answer = new int[cnt];
		for(int i=n-1; i>=0; i--){
			if(trace[i][0] == cnt){
                answer[cnt-1] = trace[i][1];
				cnt--;
			}
		}
        for(int i = 0; i < answer.length; i++){
            sb.append(answer[i] + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

    }
}
