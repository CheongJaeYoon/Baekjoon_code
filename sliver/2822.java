import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Question> arr = new ArrayList<>();
        for(int i = 0 ; i < 8; i++){
            arr.add(new Question(i+1, Integer.parseInt(br.readLine())));
        }

        
        Collections.sort(arr, new Comparator<Question>() {
            @Override
            public int compare(Question a , Question b){
                return b.getScore() - a.getScore();
            }
            
        });

        int[] arr2 = new int[5];
        int sum = 0;

        int idx = 0;
        for(Question q : arr){
            if(idx == 5)
                break;
            arr2[idx] = q.getNumber();
            sum += q.getScore();
            idx++;
        }
        Arrays.sort(arr2);
        StringBuilder result = new StringBuilder();
        result.append(sum + "\n");
        for(int i = 0 ; i < 5; i++){
            result.append(arr2[i] + " ");
        }
        System.out.println(result.toString());
    }


}

class Question{
    private int number;
    private int score;
    public Question(int number, int score){
        this.number = number;
        this.score = score;
    }
    public int getNumber() {
        return this.number;
    }
    public int getScore() {
        return this.score;
    }
}