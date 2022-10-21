import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Member> memberList = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        String name;
        int age;
        while(n-- >0){
            st = new StringTokenizer(br.readLine());
            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            memberList.add(new Member(name, age));
        }

        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member a , Member b){
                return a.getAge() - b.getAge();
            }
        });

        for(Member m : memberList){
            System.out.println(m.toString());
        }
    }


}

class Member{
    private String name;
    private int age;
    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public String toString() {
        return Integer.toString(this.age) + " " + this.name;
    }
}