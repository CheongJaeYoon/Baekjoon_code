import java.util.*;
import java.io.*;
import java.lang.Math;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        boolean[] visited = new boolean[500001];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            visited[arr[i][0]] = true;
        }
        Arrays.sort(arr, (o1, o2)-> o1[0] - o2[0]);

        int idx = 0;
        ArrayList<Integer> list_b = new ArrayList<>();
        int[][] trace = new int[n][2];
        list_b.add(arr[0][1]);
        trace[0][0] = idx;
        trace[0][1] = arr[0][0];
        for(int i = 1; i < n; i++){
            if(arr[i][1] > list_b.get(idx)){
                list_b.add(arr[i][1]);
                idx++;
                trace[i][0] = idx;
                trace[i][1] = arr[i][0];
            }
            else{
                int tmp = Collections.binarySearch(list_b, arr[i][1]);
                tmp = tmp < 0? -(tmp+1) : tmp;
                list_b.set(tmp, arr[i][1]);
                trace[i][0] = tmp;
                trace[i][1] = arr[i][0];
            }
        }
        System.out.println(n - (idx+1));

        ArrayList<Integer> not_cut = new ArrayList<>();
		for(int i=n-1; i>=0; i--){
			if(trace[i][0] == idx){
				not_cut.add(trace[i][1]);
				idx--;
			}
		}

		for(int a : not_cut)
			visited[a] = false;

        for(int i = 0; i < 500001; i++){
            if(visited[i] == true){System.out.println(i);}
        }
    }
}
