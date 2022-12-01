import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int[] set = new int[21];
        Arrays.fill(set, 0);
        StringBuilder sb = new StringBuilder("");
        while(m-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opCode = st.nextToken();
            int num = 0;
            if(opCode.equals("add")){
                num = Integer.parseInt(st.nextToken());
                set[num] = 1;
            }
            else if(opCode.equals("remove")){
                num = Integer.parseInt(st.nextToken());
                set[num] = 0;
            }
            else if(opCode.equals("check")){
                num = Integer.parseInt(st.nextToken());
                if(set[num] == 1){
                    sb.append(1 + "\n");
                }
                else{
                    sb.append(0 + "\n");
                }
            }
            else if(opCode.equals("toggle")){
                num = Integer.parseInt(st.nextToken());
                if(set[num] == 1){
                    set[num] = 0;
                }
                else{
                    set[num] = 1;
                }
            }
            else if(opCode.equals("all")){
                Arrays.fill(set, 1);
            }
            else if(opCode.equals("empty")){
                Arrays.fill(set, 0);
            }

        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }
}