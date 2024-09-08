import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class Main{

    static int k;
    static int[][] gears = new int[4][8];
    static int[] d = new int[] {-1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        for(int i = 0; i < 4; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < 8; j++) {
                gears[i][j] = tmp.charAt(j) - '0';
            }
        }
        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            rotate(-10, readInt()-1, readInt());
        }
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            sum += gears[i][0] * (1 << i);
        }
        System.out.print(sum);
    }

    private static int readInt() {
        return Integer.parseInt(st.nextToken());
    }

    private static void rotate(int parent, int gear, int dir) {
        for(int i = 0; i < 2; i++) {
            int ng = gear + d[i];
            if(ng == parent) continue;
            if(ng < 0 || ng > 3) continue;

            if(i == 0) {
                if(gears[gear][6] != gears[ng][2]) {
                    rotate(gear, ng, dir * -1);
                }
            }
            else {
                if(gears[gear][2] != gears[ng][6]) {
                    rotate(gear, ng, dir * -1);
                }
            }
        }
        rotateGear(gear, dir);
    }

    private static void rotateGear(int gear, int dir) {
        if(dir == 1) {
            int tmp = gears[gear][7];
            for(int i = 6; i >= 0; i--) {
                gears[gear][i + 1] = gears[gear][i];
            }
            gears[gear][0] = tmp;
        }
        else if(dir == -1) {
            int tmp = gears[gear][0];
            for(int i = 1; i < 8; i++) {
                gears[gear][i - 1] = gears[gear][i];
            }
            gears[gear][7] = tmp;
        }
    }
}