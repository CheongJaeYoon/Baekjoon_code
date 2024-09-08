import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main{

    static int n, l, cnt;
    static int[][] map;
    static int[] road;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    public static void main(String[] args) throws Exception{
        n = readInt();
        l = readInt();
        map = new int[n][n];
        for(int i = 0; i < n ;i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = readInt();
            }
        }
        road = new int[n];
        cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                road[j] = map[i][j];
            }
            cnt += isPass(road);
            for(int j = 0; j < n; j++) {
                road[j] = map[j][i];
            }
            cnt += isPass(road);
        }
        System.out.print(cnt);
    }

    private static int isPass(int[] road) {

        boolean first = true;
        boolean canPass = true;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int prev = road[0];
        int num = 1;

        for(int i = 1; i < n; i++) {
            if(prev == road[i]) num++;
            else if(Math.abs(prev - road[i]) == 1) {
                arrayList.add(new int[] { prev , num });
                num = 1;
            }
            else {
                canPass = false;
                break;
            }
            prev = road[i];
        }
        arrayList.add(new int[] { road[n-1] , num });

        int[] prevE = arrayList.get(0);

        for(int i = 1; i < arrayList.size(); i++) {
            int[] curE = arrayList.get(i);
            if(prevE[0] < curE[0]) {
                if(prevE[1] < l) {
                    canPass = false;
                    break;
                }
                else {
                    arrayList.set(i-1, new int[] {prevE[0], prevE[1] - l});
                }
            }
            else if(prevE[0] > curE[0]) {
                if(curE[1] < l) {
                    canPass = false;
                    break;
                }
                else {
                    arrayList.set(i, new int[] {curE[0], curE[1] - l});
                }
            }
            prevE = arrayList.get(i);
        }


        if(canPass) return 1;


        first = true;
        canPass = true;
        arrayList = new ArrayList<>();
        prev = road[n-1];
        num = 1;

        for(int i = n-2; i >= 0; i--) {
            if(prev == road[i]) num++;
            else if(Math.abs(prev - road[i]) == 1) {
                arrayList.add(new int[] { prev , num });
                num = 1;
            }
            else {
                canPass = false;
                break;
            }
            prev = road[i];
        }
        arrayList.add(new int[] { road[0] , num });

        prevE = arrayList.get(0);

        for(int i = 1; i < arrayList.size(); i++) {
            int[] curE = arrayList.get(i);
            if(prevE[0] < curE[0]) {
                if(prevE[1] < l) {
                    canPass = false;
                    break;
                }
                else {
                    arrayList.set(i-1, new int[] {prevE[0], prevE[1] - l});
                }
            }
            else if(prevE[0] > curE[0]) {
                if(curE[1] < l) {
                    canPass = false;
                    break;
                }
                else {
                    arrayList.set(i, new int[] {curE[0], curE[1] - l});
                }
            }
            prevE = arrayList.get(i);
        }


        if(canPass) return 1;

        return 0;
    }

    public static int readInt() throws Exception{
        st.nextToken();
        return (int) st.nval;
    }
}