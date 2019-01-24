package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2667 {

    static int dx[]={1,0,-1,0};
    static int dy[]={0,-1,0,1};
    static int[][] map;
    static int[][] isVisit;
    static int N;

    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isVisit = new int[N][N];
        ArrayList<Integer> list = new ArrayList<>();


        for(int i=0; i< N; i++){
            String line = br.readLine();
            for(int j=0; j< N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j =0; j<N; j++){
                if(map[i][j] == 1 && isVisit[i][j] != 1){
                    list.add(bfs(j, i));
                }
            }
        }

        Collections.sort(list);

        int size = list.size();
        System.out.println(size);
        for(int i=0; i<size; i++){
            System.out.println(list.get(i));
        }
    }

    private static int bfs(int x, int y){
        isVisit[y][x] = 1;
        int answer = 1;
        for(int i=0; i< 4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 0 && nextX < N && nextY >=0 && nextY < N && map[nextY][nextX] == 1 && isVisit[nextY][nextX] == 0 ){
                answer += bfs(nextX, nextY);
            }
        }
        return answer;
    }
}