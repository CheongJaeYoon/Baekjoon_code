import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        String[] students;
        String[][] input;
        int cnt = 1;
        boolean first = true;
        StringBuilder result = new StringBuilder();
        while(true){

            n = Integer.parseInt(br.readLine());

            if(n == 0)
                break;
            if(first == false){
                result.append("\n");
            }
            else{
                first = false;
            }
            
            result.append(("Group " + cnt + "\n"));
            students = new String[n];
            input = new String[n][n];
            for(int i = 0; i < n; i++){
                input[i] = br.readLine().split(" ");
                students[i] = input[i][0];
            }
            boolean nobody = true;
            for(int i = 0; i < n; i++){
                for(int j = 1; j < n;j++){
                    if(input[i][j].equals("N")){
                        nobody = false;
                        result.append(students[(i-j<0 ? i-j+n : i-j)] + " was nasty about " + students[i] + "\n");
                    }
                }
            }
            if(nobody == true){
                result.append("Nobody was nasty" + "\n");
            }
            cnt++;
        }
        System.out.println(result.toString());
    }
}