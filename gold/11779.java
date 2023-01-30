import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, c});
        }

        st = new StringTokenizer(br.readLine());

        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[]o2){
                return o1[1]-o2[1];
            }
        });

        int[] back = new int[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pQueue.add(new int[]{startCity, 0});
        dist[startCity] = 0;

        while(!pQueue.isEmpty()){
            int city = pQueue.peek()[0];
            int cost = pQueue.poll()[1];
            
            if(cost > dist[city])
                continue;

            for(int i = 0; i < graph.get(city).size(); i++){
                int nextcity = graph.get(city).get(i)[0];
                int nextcost = cost + graph.get(city).get(i)[1];
                if(dist[nextcity] > nextcost){
                    pQueue.add(new int[]{nextcity, nextcost});
                    dist[nextcity] = nextcost;
                    back[nextcity] = city;
                }
            }
        }


        System.out.println(dist[endCity]);
        Stack<Integer> stack = new Stack<>();
        stack.push(endCity);
        while(true){
            int tmp = back[endCity];
            if(tmp == 0){
                break;
            }
            else{
                stack.push(tmp);
                endCity = tmp;
            }
        }
        
        System.out.println(stack.size());
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}