import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " ", " ", " ", " ", " ", " "};
        int row, col, cnt, l, r, t, b, x, y;
        String code;
        StringBuilder tmp, result;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            code = st.nextToken();
            tmp = new StringBuilder();
            result = new StringBuilder();
            result.append(".");

            l = 0;
            r = col;
            t = 0;
            b = row;
            x = 0;
            y = 0;
            cnt = 0;
            while(l < r && t < b){
                for(int j = l; j < r && t < b; j++){
                    x = j;
                    tmp.append(code.charAt(x + col*y));
                    cnt++;
                    if(cnt == 5){
                        if((Integer.parseInt(tmp.toString(), 2)) == 0){
                            result.append(" ");
                        }
                        else{
                            result.append(alphabet[Integer.parseInt(tmp.toString(), 2) - 1]);
                        }
                        tmp = new StringBuilder();
                        cnt = 0;
                    }
                }
                t++;
                for(int j = t; j < b && l < r; j++){
                    y = j;
                    tmp.append(code.charAt(x + col*y));
                    cnt++;
                    if(cnt == 5){
                        if((Integer.parseInt(tmp.toString(), 2)) == 0){
                            result.append(" ");
                        }
                        else{
                            result.append(alphabet[Integer.parseInt(tmp.toString(), 2) - 1]);
                        }
                        tmp = new StringBuilder();
                        cnt = 0;
                    }
                }
                r--;
                for(int j = r - 1; j >= l && t < b; j--){
                    x = j;
                    tmp.append(code.charAt(x + col*y));
                    cnt++;
                    if(cnt == 5){
                        if((Integer.parseInt(tmp.toString(), 2)) == 0){
                            result.append(" ");
                        }
                        else{
                            result.append(alphabet[Integer.parseInt(tmp.toString(), 2) - 1]);
                        }
                        tmp = new StringBuilder();
                        cnt = 0;
                    }
                }
                b--;
                for(int j = b - 1; j >= t && l < r; j--){
                    y = j;
                    tmp.append(code.charAt(x + col*y));
                    cnt++;
                    if(cnt == 5){
                        if((Integer.parseInt(tmp.toString(), 2)) == 0){
                            result.append(" ");
                        }
                        else{
                            result.append(alphabet[Integer.parseInt(tmp.toString(), 2) - 1]);
                        }
                        tmp = new StringBuilder();
                        cnt = 0;
                    }
                }
                l++;
            }
            result = new StringBuilder(result.toString().trim());
            result.deleteCharAt(0);
            System.out.println(result.toString());


            
        }

    }


}