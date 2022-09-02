import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input_first = br.readLine().split(" ");
        int n = Integer.parseInt(input_first[0]);
        int m = Integer.parseInt(input_first[1]);
        String[] input_second = br.readLine().split(" ");
        int book[] = new int[n];
        for(int i = 0; i < n; i++){
            book[i] = Integer.parseInt(input_second[i]);
        }
        System.out.print(Arrays.toString(book));
    }
}