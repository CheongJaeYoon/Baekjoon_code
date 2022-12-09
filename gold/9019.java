import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Queue<Reg> queue = new LinkedList<>();
            Boolean[] visited = new Boolean[10000];
            Arrays.fill(visited, false);

            queue.add(new Reg(a, new StringBuilder()));
            visited[a] = true;
            while(!queue.isEmpty()){
                Reg tmp = queue.poll();
                if(tmp.getNumber() == b){
                    System.out.println(tmp.getOpCode().toString());
                    break;
                }
                if(visited[tmp.commandD()] == false){
                    visited[tmp.commandD()] = true;
                    queue.add(new Reg(tmp.commandD(), tmp.addOpCode('D')));
                }
                if(visited[tmp.commandS()] == false){
                    visited[tmp.commandS()] = true;
                    queue.add(new Reg(tmp.commandS(), tmp.addOpCode('S')));
                }
                if(visited[tmp.commandL()] == false){
                    visited[tmp.commandL()] = true;
                    queue.add(new Reg(tmp.commandL(), tmp.addOpCode('L')));
                }
                if(visited[tmp.commandR()] == false){
                    visited[tmp.commandR()] = true;
                    queue.add(new Reg(tmp.commandR(), tmp.addOpCode('R')));
                }
            }
        }
    }
}

class Reg{
    private int number;
    private StringBuilder opCode;

    Reg(int number, StringBuilder opCode){
        this.number = number;
        this.opCode = opCode;
    }

    public int getNumber() {
        return number;
    }

    public StringBuilder getOpCode() {
        return opCode;
    }

    public StringBuilder addOpCode(char op){
        StringBuilder tmp = new StringBuilder();
        tmp.append(this.opCode);
        tmp.append(op);
        return tmp;
    }

    public int commandD(){
        return (this.number*2)%10000;
    }
    public int commandS(){
        int tmp = this.number;
        tmp--;
        if(tmp == -1)
            tmp = 9999;
        return tmp;
    }
    public int commandL(){
        int tmp = 0;
        int tmp2 = this.number;
        tmp += (tmp2%10) * 10;
        tmp2 /= 10;
        tmp += (tmp2%10) * 100;
        tmp2 /= 10;
        tmp += (tmp2%10) * 1000;
        tmp2 /= 10;
        tmp += tmp2;
        return tmp;
    }
    public int commandR(){
        int tmp = 0;
        int tmp2 = this.number;
        tmp += (tmp2%10) * 1000;
        tmp2 /= 10;
        tmp += (tmp2%10);
        tmp2 /= 10;
        tmp += (tmp2%10) * 10;
        tmp2 /= 10;
        tmp += tmp2 * 100;
        return tmp;
    }
}