import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] v;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0, 0);
                handleSpecialShape(i, j);
                resetVisited();
            }
        }

        System.out.println(max);
    }

    static void dfs(int i, int j, int cnt, int sum) {
        v[i][j] = true;
        sum += map[i][j];
        if (++cnt == 4) {
            max = Math.max(max, sum);
            v[i][j] = false; // 주의해야 했던 부분
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj]) {
                dfs(ni, nj, cnt, sum);
            }
        }
        v[i][j] = false; // 주의해야 했던 부분
    }

    private static void handleSpecialShape(int i, int j) {
        int[][][] shapes = {
                {{0, 0}, {0, 1}, {0, -1}, {-1, 0}}, // ㅗ
                {{0, 0}, {-1, 0}, {1, 0}, {0, 1}},  // ㅏ
                {{0, 0}, {0, 1}, {0, -1}, {1, 0}},  // ㅜ
                {{0, 0}, {-1, 0}, {1, 0}, {0, -1}}  // ㅓ
        };

        for (int[][] shape : shapes) {
            int sum = 0;
            boolean isValid = true;

            for (int[] coord : shape) {
                int ni = i + coord[0];
                int nj = j + coord[1];
                if (ni < 0 || ni >= N || nj < 0 || nj >= M) {
                    isValid = false;
                    break;
                }
                sum += map[ni][nj];
            }

            if (isValid) {
                max = Math.max(max, sum);
            }
        }
    }

    static void resetVisited() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(v[i], false);
        }
    }
}