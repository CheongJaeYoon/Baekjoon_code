import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int case_num = Integer.parseInt(br.readLine());
        int n, m, cur_priority, queue_len, queue_idx, seq_idx, cnt;
        ArrayList<Q_element> queue;
        Integer[] print_sequence;
        for(int i = 0; i < case_num; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            queue = new ArrayList<>();
            print_sequence = new Integer[n];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                cur_priority = Integer.parseInt(st.nextToken());
                queue.add(new Q_element(cur_priority, j));
                print_sequence[j] = cur_priority;
            }
            Arrays.sort(print_sequence, Collections.reverseOrder());
            queue_idx = 0;
            seq_idx = 0;
            queue_len = n;
            cnt = 1;
            while(true){
                if(queue_idx == queue_len)
                    queue_idx = 0;
                if(queue.get(queue_idx).getPriority() == print_sequence[seq_idx]){
                    if(queue.get(queue_idx).getNumber() == m){
                        System.out.println(cnt);
                        break;
                    }
                    else{
                        queue.remove(queue_idx);
                        seq_idx++;
                        queue_idx--;
                        queue_len--;
                        cnt++;
                    }
                }
                queue_idx++;
            }


        }
    }


}

class Q_element{
    private int priority;
    private int number;
    public Q_element(int priority, int number){
        this.priority = priority;
        this.number = number;
    }
    public int getPriority() {
        return this.priority;
    }
    public int getNumber() {
        return this.number;
    }
}