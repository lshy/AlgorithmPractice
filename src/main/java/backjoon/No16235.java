package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No16235 {

    static int dx[] = {1, 0, -1, 0, 1, 1, -1, -1};
    static int dy[] = {0, -1, 0, 1, -1, 1, 1, -1};
    static int N, M, K;
    static int[][] A;
    static int[][] maps;
    static LinkedList<Tree> liveTrees;
    static LinkedList<Tree> deadTrees;

    static class Tree {
        int x;
        int y;
        int year;

        Tree(int x, int y, int year) {
            this.x = x;
            this.y = y;
            this.year = year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        liveTrees = new LinkedList<>();
        deadTrees = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                maps[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y =Integer.parseInt(st.nextToken())-1;
            liveTrees.push(new Tree(y, x, Integer.parseInt(st.nextToken())));
        }

        for(int i=0; i<K; i++){


            spring();
            summer();
            fall();
            winter();

        }

        System.out.print(liveTrees.size());


    }

    private static void spring(){
        Iterator<Tree> itr = liveTrees.iterator();

        for(; itr.hasNext();){
            Tree tree = itr.next();
            if(maps[tree.y][tree.x] < tree.year){
                deadTrees.push(new Tree(tree.x, tree.y, tree.year));
                itr.remove();
            }else{
                maps[tree.y][tree.x] -= tree.year;
                tree.year++;
            }
        }
    }

    private static void summer(){
        Iterator<Tree> itr = deadTrees.iterator();

        for(; itr.hasNext();){
            Tree tree = itr.next();
            maps[tree.y][tree.x] += (tree.year /2);
            itr.remove();
        }
    }

    private static void fall(){
        ListIterator<Tree> itr = liveTrees.listIterator();

        LinkedList<Tree> tmpList = new LinkedList<>();

        for(; itr.hasNext();){
            Tree tree = itr.next();

            if(tree.year % 5 == 0){
                for(int i=0; i<8; i++){
                    int nextX = tree.x + dx[i];
                    int nextY = tree.y + dy[i];
                    if(checkBoundary(nextX, nextY)){
                        continue;
                    }
                    tmpList.push(new Tree(nextX, nextY, 1));
                }
            }
        }

        liveTrees.addAll(0, tmpList);

    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for(int j=0; j< N; j++){
                maps[i][j] += A[i][j];
            }
        }
    }

    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= N || y <0 || y >= N){
            return true;
        }
        return false;
    }
}
