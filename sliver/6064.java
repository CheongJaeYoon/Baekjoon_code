import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int lcm = lcm(m ,n);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            int a = 0;
            int b = 0;
            boolean err = false;
            while(true){
                if(a > lcm/m || b > lcm/n){
                    err = true;
                    break;
                }
                int left = m * a + x;
                int right = n * b + y;
                if(left == right){
                    break;
                }
                if(left < right){
                    a++;
                }
                if(left > right){
                    b++;
                }
            }
            if(err){
                System.out.println(-1);
            }
            else{
                System.out.println(m * a + x);
            }
        }

    }

    public static int lcm(int m, int n){
        int a = m;
        int b = n;
        int tmp = a % b;
        while(tmp != 0){
            a = b;
            b = tmp;
            tmp = a % b;
        }
        return m * n / b;
    }


}