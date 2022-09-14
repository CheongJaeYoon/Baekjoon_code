import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        ArrayList<Student> students = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            students.add(new Student(country, number, score));
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a , Student b){
                return b.getScore() - a.getScore();
            }
            
        });

        int tmp;
        if(students.get(0).getCountry() == students.get(1).getCountry()){
            tmp = students.get(0).getCountry();
            System.out.println(students.get(0).getCountry() + " " + students.get(0).getNumber());
            System.out.println(students.get(1).getCountry() + " " + students.get(1).getNumber());
            for(int i = 2; i < n; i++){
                if(students.get(i).getCountry() != tmp){
                    System.out.println(students.get(i).getCountry() + " " + students.get(i).getNumber());
                    break;
                }
            }
        }
        else{
            for(int i = 0; i < 3; i++){
                System.out.println(students.get(i).getCountry() + " " + students.get(i).getNumber());
            }

        }

    }


}

class Student{
    private int country;
    private int number;
    private int score;
    public Student(int country, int number, int score){
        this.country = country;
        this.number = number;
        this.score = score;
    }
    public int getCountry() {
        return this.country;
    }
    public int getNumber() {
        return this.number;
    }
    public int getScore() {
        return this.score;
    }
}