package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No9328 {


    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int h, w, T;
    static char[][] map;
    static boolean[][] isVisit;
    static List<Character> keys;
    static boolean flag;
    static int visitCount, tmpVisitCount;
    static int answer;
    static List<Integer> answers;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        answers = new ArrayList<>();

        for(int k = 0; k<T; k++){

            st = new StringTokenizer(br.readLine());
            flag = true;
            keys = new ArrayList<>();
            visitCount = 0;
            tmpVisitCount = 0;


            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            isVisit = new boolean[h][w];

            for(int i= 0; i<h; i++){
                String line = br.readLine();
                for(int j= 0; j<w; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            String line = br.readLine();
            if(line.equals("0")){

            }else{
                for(int i = 0; i< line.length(); i++){
                    keys.add(Character.toUpperCase(line.charAt(i)));
                }
            }


            answer = 0;

            while(flag){
                answer = 0;
                tmpVisitCount = 0;

                for(int i= 0; i< h; i++){
                    for(int j=0; j<w; j++){
                        if(  !isVisit[i][j] && ((i == 0 || i == h-1) || (j == 0 || j == w-1))  ){
                            if(map[i][j] == '*')
                                continue;
                            if( Character.isUpperCase(map[i][j]) &&  !keys.contains(map[i][j]))
                                continue;

                            bfs(j, i);

                        }
                    }
                }

                checkStop();
                remake();

            }

            System.out.println(answer);




        }

    }

    private static void bfs(int x, int y){

        tmpVisitCount++;
        isVisit[y][x] = true;
        if(map[y][x] == '$')
            answer++;

        if(Character.isLowerCase(map[y][x]) && !keys.contains(Character.toUpperCase(map[y][x])))
            keys.add(Character.toUpperCase(map[y][x]));

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(checkBoundary(nextX, nextY) || map[nextY][nextX] == '*' || isVisit[nextY][nextX])
                continue;

            if(Character.isUpperCase(map[nextY][nextX]) && !keys.contains(map[nextY][nextX])){
                continue;
            }

            bfs(nextX, nextY);

        }
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= w || y <0 || y >= h){
            return true;
        }
        return false;
    }

    private static void checkStop(){
        if(tmpVisitCount > visitCount){

        }else{
            flag = false;
        }
        visitCount = tmpVisitCount;
    }

    private static void remake(){
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                isVisit[i][j] = false;
            }
        }
    }
}
