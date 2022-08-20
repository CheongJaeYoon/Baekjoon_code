import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        Arrays.sort(str, Collections.reverseOrder());
        String result = "";
        for(String ch : str){
            result += ch;
        }
        System.out.println(result);
    }
}