import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

        int[] month_day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int month = int_month(st.nextToken());
        int day = Integer.parseInt(st.nextToken().substring(0,2));
        int year = Integer.parseInt(st.nextToken());

        String[] tmp = st.nextToken().split(":");
        int hour = Integer.parseInt(tmp[0]);
        int min = Integer.parseInt(tmp[1]);
        
        long total_min = (is_yoon(year) + 365) * 24 * 60;
        long today_min = 0;

        for(int i = 0; i < month - 1; i++){
            today_min += (month_day[i] * 24 * 60);
            if(i == 1)
                today_min += (is_yoon(year) * 24 * 60);
        }
        today_min += (day - 1) * 24 * 60;
        today_min += hour * 60;
        today_min += min;


        System.out.println((double)today_min/total_min * 100);

    }

    public static int is_yoon(int year) {
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return 1;
                }
                return 0;
            }
            return 1;
        }
        return 0;
    }
    public static int int_month(String str) {
        int result = 0;
        switch(str) {
            case "January":
                result = 1;
                break;
            case "February":
                result = 2;
                break;
            case "March":
                result = 3;
                break;
            case "April":
                result = 4;
                break;
            case "May":
                result = 5;
                break;
            case "June":
                result = 6;
                break;
            case "July":
                result = 7;
                break;
            case "August":
                result = 8;
                break;
            case "September":
                result = 9;
                break;
            case "October":
                result = 10;
                break;
            case "November":
                result = 11;
                break;
            case "December":
                result = 12;
                break;
        };

        return result;
    }
}