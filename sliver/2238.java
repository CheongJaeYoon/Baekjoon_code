import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Participant> participants = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            boolean breaker = false;
            for(Participant p : participants){
                if(p.getPrice() == price){
                    p.addNumber();
                    breaker = true;
                    break;
                }
            }
            if(breaker == true){
                continue;
            }
            participants.add(new Participant(name, price));
        }
        Collections.sort(participants, new Comparator<Participant>() {
            @Override
            public int compare(Participant a , Participant b){
                if(a.getNumber() == b.getNumber()){
                    return a.getPrice() - b.getPrice();
                }
                else{
                    return a.getNumber() - b.getNumber();
                }
            }
            
        });
        System.out.println(participants.get(0).getName() + " " + participants.get(0).getPrice());

    }


}

class Participant{
    private String name;
    private int price;
    private int number;
    public Participant(String name, int price){
        this.name = name;
        this.price = price;
        this.number = 1;
    }
    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
    public int getNumber() {
        return this.number;
    }
    public void addNumber() {
        this.number++;
    }
}