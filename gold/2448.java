import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static StringBuilder[] str;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        str = new StringBuilder[n];
        str[0] = new StringBuilder("  *  ");
        str[1] = new StringBuilder(" * * ");
        str[2] = new StringBuilder("*****");
        func(n/3, str, 5, 3);
        for(int i = 0; i < n; i++){
            System.out.println(str[i].toString());
        }

    }
    public static void func(int cnt, StringBuilder[] str, int garo, int sero){
        if(cnt == 1){
            return;
        }
        int blank = (garo + 1)/2;
        for(int i = sero; i < sero * 2; i++){
            str[i] = new StringBuilder("");
            str[i].append(str[i-sero]);
            str[i].append(" ");
            str[i].append(str[i-sero]);

        }
        for(int i = 0; i < sero; i++){
            for(int j = 0; j < blank; j++){
                str[i].append(" ");
                str[i].insert(0, " ");
            }
        }

        func(cnt/2, str, garo*2 + 1, sero*2);
    }
}