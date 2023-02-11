import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
    static int min;
    static int c_size, h_size;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> house;
    static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        min = Integer.MAX_VALUE;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j < n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    house.add(new int[]{i, j});
                }
                else if(tmp == 2){
                    chicken.add(new int[]{i, j});
                }
            }
        }

        c_size = chicken.size();
        h_size = house.size();
        func(-1, 0);
        System.out.println(min);
    }

    public static void func(int prev, int cnt){
        if(cnt == m){
            dist();
        }
        else{
            for(int i = prev+1; i < c_size; i++){
                arr[cnt] = i;
                func(i, cnt+1);
            }
        }
    }

    public static void dist(){
        int sum = 0;
        for(int i = 0; i < h_size; i++){
            int tmp = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                int distance = Math.abs(chicken.get(arr[j])[0] - house.get(i)[0]) + Math.abs(chicken.get(arr[j])[1] - house.get(i)[1]);
                tmp = tmp > distance ? distance : tmp;
            }
            sum += tmp;
        }
        min = min > sum ? sum : min;
        //System.out.print(Arrays.toString(arr));
        //System.out.println(" sum = " + sum);
    }
}