package backjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class No2573_1 {


    static int N, M;
    static int[][] map;
    static int[][] saveMap;
    static boolean[][] isVisit;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, -1, 0, 1};
    static Stack<Point> stack;
    static int iceLandTotal;
    static int iceLandTmp;
    static int iceLandMelt;


    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new int[N][M];
        isVisit = new boolean[N][M];
        saveMap = new int[N][M];
        stack = new Stack<>();
        iceLandTotal = 0;
        iceLandTmp = 0;
        iceLandMelt = 0;
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] !=0){
                    iceLandTotal++;
                }
                saveMap[i][j] = 0;
            }
        }
        int answer = 0;
        boolean flag = false;
        boolean flag2 = false;


        while(true){
            iceLandMelt = 0;

            flag = false;
            flag2 = false;

        answer++;
//        checkOcean();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0){
                    isVisit[i][j] = true;
                    dfs(new Point(j, i));
                    isVisit[i][j] = false;
                    flag = true;
                    break;
                }
            }
            if(flag){

                break;
            }
        }

        System.out.println();
            printMap();





            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] != 0){
                        iceLandMelt = 1;
                        isVisit[i][j] = true;
                        dddfs(new Point(j, i));
                        isVisit[i][j] = false;
                        flag2 = true;
                        break;
                    }
                }
                if(flag2){
                    break;
                }
            }

            if(iceLandMelt != iceLandTotal){
//                printMap();
                System.out.println(answer);
                break;
            }else{
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        isVisit[i][j] = false;
                    }
                }
            }

            if(iceLandTotal == 0){
                System.out.println(0);
                break;
            }


        }

    }

    static private void dfs(Point p){

        int ocean = 0;

        for(int i=0; i<4; i++){
            int nextX = p.x + dx[i];
            int nextY = p.y + dy[i];
            if(map[nextY][nextX] == 0){
                ocean++;
            }else if(map[nextY][nextX] != 0 &&!isVisit[nextY][nextX]){
                isVisit[nextY][nextX] = true;
                stack.push(new Point(nextX, nextY));
            }
        }


        while(!stack.isEmpty()){
            dfs(stack.pop());
        }
        map[p.y][p.x] -= ocean;
        map[p.y][p.x] = map[p.y][p.x] > 0 ? map[p.y][p.x] : 0;

        if(map[p.y][p.x] == 0){
            iceLandTotal--;
        }
        isVisit[p.y][p.x] = false;
    }

    static private void dddfs(Point p){


        isVisit[p.y][p.x] = true;

        for(int i=0; i<4; i++){
            int nextX = p.x + dx[i];
            int nextY = p.y + dy[i];
            if(map[nextY][nextX] != 0 &&!isVisit[nextY][nextX]){
                iceLandMelt++;
                dddfs(new Point(nextX, nextY));
            }
        }
//        isVisit[p.y][p.x] = false;
    }


//    static private void checkOcean() {
//        for (int i = 0; i < N - 2; i++) {
//            for (int j = 0; j < M - 2; j++) {
//                int x = j + 1;
//                int y = i + 1;
//                int ocean = 0;
//                if (map[y][x] != 0) {
//
//                    for (int k = 0; k < 4; k++) {
//                        int nextX = x + dx[k];
//                        int nextY = y + dy[k];
//                        if (map[nextY][nextX] == 0) {
//                            ocean++;
//                        }
//                    }
//
//                    saveMap[y][x] = ocean;
//                }
//            }
//        }
//
//    }


    static private void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
