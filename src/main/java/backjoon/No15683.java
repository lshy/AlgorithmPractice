
package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No15683 {

    static boolean[][][] dcctv;
    static int[][] map, tmpMap;

    static ArrayList<Integer> list;
    static ArrayList<Integer> fist;

    public static void main(String[] args) throws IOException {

        dcctv = new boolean[][][]{

                {{true, false, false, false}, {false, true, false, false}, {false, false, true, false}, {false, false, false, true}},
                {{true, false, true, false}, {false, true, false, true}, {false, false, false, false}, {false, false, false, false}},
                {{true, true, false, false}, {false, true, true, false}, {false, false, true, true}, {true, false, false, true}},
                {{true, true, true, false}, {false, true, true, true}, {true, false, true, true}, {true, true, false, true}}

        };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        fist = new ArrayList<>();

        map = new int[N][M];
        tmpMap = new int[N][M];

        for(int i=0; i<N; i++){

            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){

                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;
                tmpMap[i][j] = num;

                if(num < 5 && num >0){
                    list.add(num-1);

                }else if(num == 5){

                }
            }
        }




    }
}
