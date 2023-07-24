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

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] cost = new int[n];
        int[] time = new int[n];
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            time[i] = Integer.parseInt(st.nextToken());
        }
        String answer = new Main().solution(n, c, t, cost, time);
        System.out.println(answer);
    }

    public String solution(int n, int c, int t, int[] cost, int[] time) {
        ArrayList<Node> currentNodeList = new ArrayList<>();
        ArrayList<Queue<Node>> timeQueues = new ArrayList<>();
        ArrayList<Queue<Node>> waitQueues = new ArrayList<>();
        for(int i = 0; i <= t; i++){
            timeQueues.add(new LinkedList<>());
            waitQueues.add(new LinkedList<>());
        }

        Unit rootUnit = new Unit(1, 0);
        Node root = new Node(rootUnit, 0,  0,null, new ArrayList<>());
        currentNodeList.add(root);

        int currentTime = 0;
        while(currentTime <= t){


            if(!timeQueues.get(currentTime).isEmpty()){
                Queue<Node> timeQueue = timeQueues.get(currentTime);
                Queue<Node> waitQueue = waitQueues.get(currentTime);
                while(!waitQueue.isEmpty()){
                    Node node = waitQueue.poll();
                    currentNodeList.add(node);
                }
                while(!timeQueue.isEmpty()){
                    Node node = timeQueue.poll();
                    addCost(node, node.cost);
                    if(node.unit.level == n){
                        node.cnt = 1;
                        addCnt(node);
                    }
                    node.parent.nodeList.add(node);
                    currentNodeList.add(node);
                }
            }

            for(int i = 0; i < currentNodeList.size(); i++){
                Node currentNode = currentNodeList.get(i);
                if(currentNode.unit.level == n) continue;

                int nextTime = currentTime + time[currentNode.unit.level];
                if( nextTime <= t ){
                    waitQueues.get(nextTime).add(currentNode);
                    timeQueues.get(nextTime).add(new Node(new Unit(currentNode.unit.level+1, nextTime), cost[currentNode.unit.level], 0, currentNode, new ArrayList<>()));
                    currentNodeList.remove(currentNode);
                    i--;
                }
            }
            currentTime++;
        }
        pruning(root, n);
        showTree(root);
        Stack<Rollback> stack = new Stack<Rollback>();
        while(root.cost > c){

        }


        return "hi";
    }

    public void addCost(Node node, int cost){
        if(node.parent != null){
            node.parent.cost += cost;
            addCost(node.parent, cost);
        }
    }
    public void addCnt(Node node){
        if(node.parent != null){
            node.parent.cnt += 1;
            addCnt(node.parent);
        }
    }

    public void deleteCost(Node node, int cost){
        if(node.parent != null){
            node.parent.cost -= cost;
            deleteCost(node.parent, cost);
        }
    }

    public void pruning(Node root, int maxLevel){
        if(root.unit.level == maxLevel) return;

        for(int i = 0; i < root.nodeList.size(); i++){
            Node node = root.nodeList.get(i);
            if(node.cnt == 0){
                deleteCost(node, node.cost);
                node.parent.nodeList.remove(node);
                i--;
            }
            else{
                pruning(node, maxLevel);
            }
        }
    }

    public void showTree(Node node){
        if(node.nodeList.isEmpty()) return;
        System.out.println("레벨: " + node.unit.level + " , 만들어진 시간: " + node.unit.createdTime + " , 생산량: " + node.cnt + ", 총 비용: " + node.cost + ", 비용/생산량: " + node.getCntPerCost());

        for(Node child : node.nodeList){
            System.out.println("레벨: " + child.unit.level + " , 만들어진 시간: " + child.unit.createdTime+ " , 생산량: " + child.cnt + ", 총 비용: " + child.cost + ", 비용/생산량: " + child.getCntPerCost() + "|");
        }
        System.out.println("--------------------------------------------------------------------------------");
        for(Node child : node.nodeList){
            showTree(child);
        }
    }
    class Rollback{
        int rollbackCost;

    }

    class Unit{
        int level;
        int createdTime;

        public Unit(int level, int createdTime) {
            this.level = level;
            this.createdTime = createdTime;
        }
    }

    class Node{
        Unit unit;
        int cost;
        int cnt;
        Node parent;
        ArrayList<Node> nodeList;

        public Node(Unit unit, int cost, int cnt, Node parent, ArrayList<Node> nodeList) {
            this.unit = unit;
            this.cost = cost;
            this.cnt = cnt;
            this.parent = parent;
            this.nodeList = nodeList;
        }

        public double getCntPerCost() {
            return (double)this.cost/(double)this.cnt;
        }

    }

}

*/
