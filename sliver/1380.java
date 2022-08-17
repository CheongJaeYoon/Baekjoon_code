import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = -1;
        String result = "";
        String[] students;
        int[] cnt;
        int num = 1;
        while(true){
            int i;
            n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            else{
                if(num != 1)
                    result += "\n";
            }
            students = new String[n];
            cnt = new int[n];
            for(i = 0; i < n; i++){
                students[i] = br.readLine();
                cnt[i] = 0;
            }
            for(i = 0; i < 2*n - 1; i++){
                cnt[Integer.parseInt(br.readLine().split(" ")[0]) - 1]++;
            }
            for(i = 0; i < n; i++){
                if(cnt[i] == 1)
                    result += (num + " " + students[i]);
            }
            num++;
        }
        System.out.println(result);
    }
}