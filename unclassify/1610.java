import java.util.*;
import java.io.*;


//이게 왜 안되는지 모르겠음...

class Main{
    public static int c, n, t;
    public static int totalCost = 0;
    public static int sum = 0;
    public static int[] cost, time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        cost = new int[n];
        t = Integer.parseInt(st.nextToken());
        time = new int[n];
        for(int i = 1; i < n ;i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        Node root = new Node(1, 0);

        func(root);
        System.out.println(sum);
    }

    public static void func(Node node){

        int cLevel = node.getLevel();
        int cTime = node.getTime();

        if(cLevel != n){

            int unit_cost = cost[cLevel];
            int unit_time = time[cLevel];

            for(int i = cTime + unit_time; i <= t; i += unit_time){
                node.addNode(new Node(cLevel+1, i));
            }
            
            LinkedList<Node> cNodes = node.getNodes();
            for(int i = 0; i < cNodes.size(); i++){
                Node tmp = cNodes.get(i);
                totalCost += unit_cost;
                if(totalCost > c){
                    break;
                }
                func(tmp);
            }
        }
        else{
            sum++;
        }
    }

}

class Node{
    public int level;
    public int time;
    public LinkedList<Node> nodes;

    Node(int level, int time){
        this.level = level;
        this.time = time;
        this.nodes = new LinkedList<>();
    }
    public int getLevel(){
        return this.level;
    }
    public int getTime(){
        return this.time;
    }
    public LinkedList<Node> getNodes(){
        return this.nodes;
    }
    public void addNode(Node node){
        this.nodes.add(node);
    }
}