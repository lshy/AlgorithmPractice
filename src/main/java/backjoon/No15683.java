
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15683 {

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static boolean[][][] dcctv;
    static int[][] map, tmpMap;
    static int N, M, count, answer;
    static int[] visited;

    static ArrayList<Cctv> list;
    static ArrayList<Cctv> fist;

    static class Cctv{
        int x;
        int y;
        int kind;
        Cctv(int x, int y, int kind){
            this.x = x;
            this.y = y;
            this.kind = kind;
        }
    }


    public static void main(String[] args) throws IOException {

        dcctv = new boolean[][][]{

                {{true, false, false, false}, {false, true, false, false}, {false, false, true, false}, {false, false, false, true}},
                {{true, true, false, false}, {false, false, true, true}, {false, false, false, false}, {false, false, false, false}},
                {{true, false, true, false}, {false, true, true, false}, {true, false, false, true}, {false, true, false, true}},
                {{true, true, true, false}, {false, true, true, true}, {true, false, true, true}, {true, true, false, true}}

        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<Cctv>();
        fist = new ArrayList<Cctv>();

        map = new int[N][M];
        tmpMap = new int[N][M];
        answer = 90;

        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){

                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;

                if(num < 5 && num >0){
                    list.add(new Cctv(j, i, num-1));

                }else if(num == 5){
                    fist.add(new Cctv(j, i, num));
                }
            }
        }

        count = list.size();
        visited = new int[count];

        int length = fist.size();

        for(int i=0; i<length; i++){
            Cctv cctv = fist.get(i);

            for(int j=0; j<4; j++){
                int nextX = cctv.x + dx[j];
                int nexyY = cctv.y + dy[j];

                while(true){
                    if((checkBoundary(nextX, nexyY) || map[nexyY][nextX] == 6) ){
                        break;
                    }
                    map[nexyY][nextX] = 7;
                    nextX += dx[j];
                    nexyY += dy[j];
                }
            }
        }
        copyMap();

        algorithm(0);

        System.out.println(answer);


    }


    private static boolean checkBoundary(int x, int y){
        if(x < 0 || x >= M || y <0 || y >= N){
            return true;
        }
        return false;
    }

    private static void copyMap(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                tmpMap[i][j] = map[i][j];
            }
        }
    }

    private static void algorithm(int depth){
        if(depth == count){
            for(int i=0; i<count; i++){
                Cctv cctv = list.get(i);
                for(int j=0; j<4; j++){
                    if(!dcctv[cctv.kind][visited[i]][j])
                        continue;

                    int nextX = cctv.x + dx[j];
                    int nexyY = cctv.y + dy[j];

                    while(true){
                        if((checkBoundary(nextX, nexyY) || tmpMap[nexyY][nextX] == 6) ){
                            break;
                        }
                        tmpMap[nexyY][nextX] = 7;
                        nextX += dx[j];
                        nexyY += dy[j];
                    }
                }

            }

            int tmp = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(tmpMap[i][j] == 0)
                        tmp++;
                }
            }

            answer = Math.min(answer, tmp);

            copyMap();



        }else{
            for(int i=0; i<4; i++){
                visited[depth] = i;
                algorithm(depth+1);
            }
        }



    }
}
