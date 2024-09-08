import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main{

    static int n;
    static long max, min;
    static long[] a;
    static int[] symbolCnt = new int[4];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    public static void main(String[] args) throws Exception{
        n = readInt();
        a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = (long) readInt();
        }
        for(int i = 0; i < 4; i++) {
            symbolCnt[i] = readInt();
        }
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        dfs(1, symbolCnt[0], symbolCnt[1], symbolCnt[2], symbolCnt[3], (long)a[0]);
        System.out.println(max);
        System.out.print(min);
    }

    public static void dfs(int idx, int s1, int s2, int s3, int s4, long sum) {
        if(idx == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        else {
            if(s1 > 0) {
                dfs(idx+1, s1-1, s2, s3, s4, sum + a[idx]);
            }
            if(s2 > 0) {
                dfs(idx+1, s1, s2-1, s3, s4, sum - a[idx]);
            }
            if(s3 > 0) {
                dfs(idx+1, s1, s2, s3-1, s4, sum * a[idx]);
            }
            if(s4 > 0) {
                dfs(idx+1, s1, s2, s3, s4-1, sum / a[idx]);
            }
        }
    }

    public static int readInt() throws Exception{
        st.nextToken();
        return (int) st.nval;
    }
}