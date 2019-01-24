package backjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class No14503_1 {
    enum Direction {
        NORTH(-1, 0),
        EAST(0, 1),
        SOUTH(1, 0),
        WEST(0, -1);

        private int dx;
        private int dy;

        Direction(int dy, int dx) {
            this.dx = dx;
            this.dy = dy;
        }

    }

    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        LinkedList<Direction> queue = new LinkedList<>();

        queue.add(Direction.WEST);
        queue.add(Direction.SOUTH);
        queue.add(Direction.EAST);
        queue.add(Direction.NORTH);


        for(int i=0; i< d; i++){
            queue.push(queue.pollLast());
        }

        int answer = 1;
        boolean flag = false;
        map[r][c] = -1;

        while(true){

            flag = true;
            for(int i=0; i<4; i++){
                Direction direction = queue.pop();
                queue.add(direction);
                int dy = r + direction.dy;
                int dx = c + direction.dx;
                if(dy >= 0 && dy < N && dx >= 0 && dx < M){
                    if(map[dy][dx] == 0){
                        map[dy][dx] = -1;
                        r = dy;
                        c = dx;
                        answer++;
                        flag = false;
                        break;
                    }

                }

            }

            if(flag){
                Direction direction = queue.getLast();
                int dy = r+ direction.dy * -1;
                int dx = c + direction.dx * -1;
                if(dy >= 0 && dy < N && dx >= 0 && dx < M && map[dy][dx] != 1){
                    r = dy;
                    c = dx;
                }else{
                    break;
                }
            }




        }

        System.out.println(answer);
    }
}
