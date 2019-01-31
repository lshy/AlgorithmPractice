package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] grades = new int[N];

        for(int i=0; i<N; i++){
            grades[i] = Integer.parseInt(st.nextToken());
        }

        double maxGrade = Arrays.stream(grades).max().getAsInt();
        double newAverage = 0;

        for(int i=0; i<N; i++){
            newAverage +=grades[i] / maxGrade * 100;
        }

        System.out.println(newAverage/N);



    }
}
