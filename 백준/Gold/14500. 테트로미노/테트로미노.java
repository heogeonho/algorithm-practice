import java.io.*;
import java.util.*;

// dfs 예외 모양만 따로 처리하기 구현이 어려웠던 문제
// 아이디어 좀 더 생각해야 했던 문제

public class Main {
    static int N, M, max = 0;
    static int[][] map;
    static boolean[][] v;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 모든 좌표에서 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                v[i][j] = true;
                dfs(i, j, map[i][j], 1);
                v[i][j] = false;
                checkT(i, j);
            }
        }

        System.out.println(max);
    }

    static void dfs(int i, int j, int sum, int cnt) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni >= 0 && nj >= 0 && ni < N && nj < M && !v[ni][nj]) {
                v[ni][nj] = true;
                dfs(ni, nj, sum + map[ni][nj], cnt + 1);
                v[ni][nj] = false;
            }
        }
    }

    // DFS로 만들 수 없는 ‘ㅗ’ 모양 직접 체크 !!!
    static void checkT(int i, int j) {
        int[][][] shapes = {
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},   // ㅜ
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},   // ㅏ
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},  // ㅗ
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}}   // ㅓ
        };

        for (int[][] shape : shapes) {
            int sum = 0;
            boolean ok = true;

            for (int[] b : shape) {
                int ni = i + b[0];
                int nj = j + b[1];
                if (ni >= 0 && nj >= 0 && ni < N && nj < M) {
                    sum += map[ni][nj];
                } else {
                    ok = false;
                    break;
                }
            }

            if (ok) max = Math.max(max, sum);
        }
    }
}