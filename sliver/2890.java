import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Boat> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String tmp;
        char tmp2;
        for(int i = 0; i < r; i++){
            tmp = br.readLine();
            for(int j = c - 1; j >=0; j-- ){
                tmp2 = tmp.charAt(j);
                if(tmp2 != 'S' && tmp2 != 'F' && tmp2 != '.'){
                    arr.add(new Boat(tmp2 - '0', c - j));
                    break;
                }
            }
        }


        
        Collections.sort(arr, new Comparator<Boat>() {
            @Override
            public int compare(Boat a , Boat b){
                return a.getLastDist() - b.getLastDist();
            }
            
        });
        int tmp3 = 0;
        int[] rank = new int[9];
        int idx = 0;
        for(Boat b : arr){
            if(tmp3 == b.getLastDist()){
                continue;
            }
            else{
                tmp3 = b.getLastDist();
                rank[idx] = tmp3;
                idx++;
            }
        }
        Collections.sort(arr, new Comparator<Boat>() {
            @Override
            public int compare(Boat a , Boat b){
                return a.getTeamNum() - b.getTeamNum();
            }
            
        });
        for(Boat b : arr){
            for(int i = 0; i < 9; i++){
                if(b.getLastDist() == rank[i]){
                    System.out.println(i+1);
                }
            }
        }
    }


}

class Boat{
    private int teamNum;
    private int lastDist;
    public Boat(int teamNum, int lastDist){
        this.teamNum = teamNum;
        this.lastDist = lastDist;
    }
    public int getTeamNum() {
        return this.teamNum;
    }
    public int getLastDist() {
        return this.lastDist;
    }
}