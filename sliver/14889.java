import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main{

    static int n;
    static long min, sSum, lSum;
    static int[][] s;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    public static void main(String[] args) throws Exception{
        n = readInt();
        s = new int[n][n];
        for(int i = 0; i < n ;i++) {
            for(int j = 0; j < n; j++) {
                s[i][j] = readInt();
            }
        }
        visited = new boolean[n];
        visited[0] = true;
        min = Long.MAX_VALUE;
        dfs(0, 1);
        System.out.print(min);
    }

    private static void dfs(int prev, int cnt) {
        if(cnt == n/2) {
            calc();
        }
        else {
            for(int i = prev + 1; i < n; i++) {
                visited[i] = true;
                dfs(i, cnt+1);
                visited[i] = false;
            }
        }
    }

    private static void calc() {
        long sSum = 0L;
        long lSum = 0L;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                if(visited[i] && visited[j]) {
                    sSum += s[i][j];
                }
                else if(!visited[i] && !visited[j]) {
                    lSum += s[i][j];
                }
            }
        }
        min = Math.min(min, Math.abs(sSum - lSum));
    }

    public static int readInt() throws Exception{
        st.nextToken();
        return (int) st.nval;
    }
}