//package backjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//public class No3197 {
//
//    static class Point{
//        int x;
//        int y;
//        int time;
//        Point(int x, int y, int time){
//            this.x = x;
//            this.y = y;
//            this.time = time;
//        }
//    }
//
//    static class Check{
//        boolean male;
//        boolean female;
//        Check(){
//            this.male = false;
//            this.female = false;
//        }
//    }
//
//    static int dx[] = {1, 0, -1, 0};
//    static int dy[] = {0, -1, 0, 1};
//
//    static int R, C;
//    static char[][] map;
//    static Check[][] checkMap;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//
//        map = new char[R][C];
//        checkMap = new Check[R][C];
//        LinkedList<Point> queue = new LinkedList<>();
//        LinkedList<Point> tmpQueue = new LinkedList<>();
//
//
//        for(int i=0; i<R; i++){
//            String line = br.readLine();
//            for(int j=0; j<C; j++){
//                char input = line.charAt(j);
//                if(input == 'L')
//                    queue.add(new Point(j, i, 0));
//
//                map[i][j] = input;
//            }
//        }
//
//        while(!queue.isEmpty()){
//            Point p = queue.pop();
//
//            for(int i=0; i<4; i++){
//                int nextX = p.x + dx[i];
//                int nextY = p.y + dy[i];
//                if(checkBoundary(nextX, nextY))
//                    continue;
//
//                if(map[nextY][nextX] == 'X')
//
//            }
//        }
//
//
//
//
//    }
//
//    private static boolean checkBoundary(int x, int y){
//        if(x < 0 || x >= C || y <0 || y >= R){
//            return true;
//        }
//        return false;
//    }
//}
