import java.io.*;
import java.util.*;

/*
 * 최대 점수와 최소 점수를 구해야 함
 * 이동 -> i가 +1 진행시 j는 (j+1 ~ j-1) 가능
 * 
 */

class Main {
    static int N;
    static int[][] map;
    static int[][] maxDp;
    static int[][] minDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][3];
        maxDp = new int[N][3];
        minDp = new int[N][3];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 식 maxDp[n+1][m] = max(maxDp[n][m-1], max(maxDp[n][m], maxDp[n][m+1])) + map[n+1][m]

        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = map[0][i];
            minDp[0][i] = map[0][i];
        }
        
        for (int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                if(j==0) {
                    maxDp[i][j] = Integer.max(maxDp[i-1][0], maxDp[i-1][1]) + map[i][j];
                    minDp[i][j] = Integer.min(minDp[i-1][0], minDp[i-1][1]) + map[i][j];
                } else if (j==1) {
                    maxDp[i][j] = Integer.max(maxDp[i-1][0], Integer.max(maxDp[i-1][1],maxDp[i-1][2])) + map[i][j];
                    minDp[i][j] = Integer.min(minDp[i-1][0], Integer.min(minDp[i-1][1],minDp[i-1][2])) + map[i][j];
                } else {
                    maxDp[i][j] = Integer.max(maxDp[i-1][1], maxDp[i-1][2]) + map[i][j];
                    minDp[i][j] = Integer.min(minDp[i-1][1], minDp[i-1][2]) + map[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Integer.max(max, maxDp[N-1][i]);
            min = Integer.min(min, minDp[N-1][i]);
        }
        System.out.println(max+" "+min);
    }
}