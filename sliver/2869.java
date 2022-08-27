import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ipt = br.readLine().split(" ");
        int a = Integer.parseInt(ipt[0]);
        int b = Integer.parseInt(ipt[1]);
        int v = Integer.parseInt(ipt[2]);
        if(a >= v)
            System.out.println(1);
        else{
            double tmp = (double)v - a;
            System.out.println((int)(Math.ceil(tmp/(a-b)) + 1));
        }
    }
}