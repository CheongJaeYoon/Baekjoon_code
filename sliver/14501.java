import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int n;
    static int[] t;
    static int[] p;
    public static void main(String[] args) throws Exception {
        n = readInt();
        t = new int[n+1];
        p = new int[n+1];
        for(int i = 1; i <= n ;i++) {
            t[i] = readInt();
            p[i] = readInt();
        }

        int[] dp = new int[n+2];
        for(int i = 1; i <= n; i++) {
            int next = i + t[i];
            if(next <= n+1) {
                if(dp[next] < dp[i] + p[i]) {
                    dp[next] = dp[i] + p[i];
                }
            }
            if(dp[i] > dp[i+1]) dp[i+1] = dp[i];
        }
        System.out.print(dp[n+1]);
    }

    public static int readInt() throws Exception {
        st.nextToken();
        return (int) st.nval;
    }

}