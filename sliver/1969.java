import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n, m;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        String[] dna = new String[n];
        int[] ham_dis = new int[n];
        Arrays.fill(ham_dis, 0);

        for(int i = 0; i < n; i++){
            dna[i] = br.readLine();
        }

        StringBuilder dna_s = new StringBuilder();
        int[] acgt = new int[4];

        for(int i = 0; i < m; i++){
            Arrays.fill(acgt, 0);
            for(int j = 0; j < n; j++){
                if(dna[j].charAt(i) == 'A')
                    acgt[0]++;
                if(dna[j].charAt(i) == 'C')
                    acgt[1]++;
                if(dna[j].charAt(i) == 'G')
                    acgt[2]++;
                if(dna[j].charAt(i) == 'T')
                    acgt[3]++;
            }

            int max = acgt[0];
            int num = 0;
            for(int j = 0; j < 4; j++){
                if(max < acgt[j]){
                    max = acgt[j];
                    num = j;
                }
            }
            if(num == 0)
                dna_s.append("A");
            if(num == 1)
                dna_s.append("C");
            if(num == 2)
                dna_s.append("G");
            if(num == 3)
                dna_s.append("T");
        }
        System.out.println(dna_s.toString());

        int cnt = 0;
        for(int i = 0; i < n; i++){
            cnt +=hamming_distance(dna_s.toString(), dna[i], m);
        }
        System.out.print(cnt);

    }

    public static int hamming_distance( String dna1, String dna2 , int m) {
        int cnt = 0;
        for(int i = 0; i < m; i++){
            if(dna1.charAt(i) != dna2.charAt(i))
                cnt++;
        }
        return cnt;
    }
}