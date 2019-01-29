package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No11559 {

    static LinkedList<LinkedList<Character>> lists;
    static boolean[][] isVisit;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};



    public static void main(String[] args) throws IOException {
        lists = new LinkedList<>();
        isVisit = new boolean[6][12];

        for(int i=0; i<6; i++){
            lists.add(new LinkedList<Character>());
        }

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        for(int i=0; i<12; i++){
            String line = br.readLine();
            for(int j =0; j<6; j++){
                lists.get(j).push(line.charAt(j));
            }
        }


        int totalLand = 2;
        int answer = -1;

        while(totalLand != 0){
            deleteDat();

            totalLand = 0;
            answer++;

            for(int i=0; i<6; i++){
                int size = lists.get(i).size();
                for(int j=0; j<size; j++){
                    if(!isVisit[i][j]){
                        int tmp = bfs(j, i, 0, lists.get(i).get(j));
                        totalLand += (tmp >= 4? tmp : 0);
                    }
                }
            }

            resetIsvisit();
        }
        System.out.print(answer);



    }

    static private int bfs(int x, int y, int land, char comp){
        land++;
        isVisit[y][x] = true;

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextY >= 0 && nextY < 6 && nextX >= 0 && nextX < lists.get(nextY).size() &&  !isVisit[nextY][nextX] && lists.get(nextY).get(nextX).equals(comp)){
                land = bfs(nextX, nextY, land, comp);
            }
        }

        if(land >= 4){
            lists.get(y).set(x, '.');
        }

        return land;
    }

    static private void deleteDat(){
        for(int i=0; i<6; i++){

//            lists[i].removeIf(character -> character == '.');

            for(Iterator<Character> itr = lists.get(i).iterator(); itr.hasNext();){
                if(itr.next().equals('.')){
                    itr.remove();
                }
            }
        }
    }

    static private void resetIsvisit(){
        for(int i=0; i<6; i++){
            for(int j=0; j<12; j++){
                isVisit[i][j] = false;
            }
        }
    }
}
