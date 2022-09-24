import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.math.BigDecimal;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        String teletype_codes = "PQWERTYUIOJ#SZK*?F@D!HNM&LXGABCV";
        char teletype_code;
        int sign;
        String tmp = "";
        String tmp2;
        double tmp3;
        double sum;
        for(int i = 0; i < n ;i++){
            st = new StringTokenizer(br.readLine());
            teletype_code = st.nextToken().charAt(0);
            sign = 1;
            tmp3 = 0.5;
            sum = 0;
            for(int j = 0; j < 32; j++){
                if(teletype_code == teletype_codes.charAt(j)){
                    tmp2 = "00000" + Integer.toBinaryString(j);
                    tmp = tmp2.substring(tmp2.length()-5);
                }
            }
            if(tmp.charAt(0) == '1'){
                sign = -1;
            }
            tmp = tmp.substring(1);
            tmp2 = "00000000000" + Integer.toBinaryString(Integer.parseInt(st.nextToken()));
            tmp = tmp + tmp2.substring(tmp2.length()-11);
            if(st.nextToken().charAt(0) == 'F'){
                tmp = tmp + "0";
            }
            else{
                tmp = tmp + "1";
            }

            for(int j = 0; j < 16; j++){
                if(tmp.charAt(j) == '1'){
                    sum += tmp3;
                }
                tmp3 = tmp3 / 2;
            }
            if(sign == -1)
                sum = 1 - sum;

            if(sum == 0 || sum == 1){
                result.append((sign * sum) + "\n");
            }
            else{   
                result.append(new BigDecimal(sign * sum) + "\n");
            }
        }
        System.out.println(result.toString());
    }
}