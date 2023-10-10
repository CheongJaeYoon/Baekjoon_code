import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(br);
    static int n, b, c;
    static int[] a;
    public static void main(String[] args) throws Exception{
        n = readInt();
        a = new int[n];
        for(int i = 0; i < n ;i++){
            a[i] = readInt();
        }
        b = readInt();
        c = readInt();
        long sum = 0;
        for(int i = 0; i < n ;i++){
            a[i] -= b;
            sum++;
            if(a[i] > 0){
                if(a[i]%c == 0){
                    sum += (a[i]/c);
                }
                else{
                    sum += (a[i]/c + 1);
                }
            }
        }
        System.out.println(sum);
    }
    public static int readInt() throws Exception{
        st.nextToken();
        return (int) st.nval;
    }
}
