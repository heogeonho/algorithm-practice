import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] di = new int[]{-1, 0, 1, 0};
    static final int[] dj = new int[]{0, 1, 0, -1};
    static int N, M, yearCnt;
    static int[][] map;
    static boolean[][] isIce;
    static boolean[][] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isIce = new boolean[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if (temp != 0) isIce[i][j] = true;
            }
        }

        // 빙산 시간 흐름 체크
        while (!emptyIce(isIce)) {
            afterYear();
            yearCnt++;
            isVisited = new boolean[N][M];
            if (countIce() > 1) {
                break;
            }
        }
        
        // 결과 출력
        if (emptyIce(isIce)) {
            System.out.println("0");
        } else {
            System.out.println(yearCnt);
        }
    }

    static int countIce() {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isIce[i][j] && !isVisited[i][j]) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        return result;
    }

    static void dfs(int i, int j) {
        isVisited[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (ni >= 0 && ni < N && nj >= 0 && nj < M && !isVisited[ni][nj] && isIce[ni][nj]) {
                dfs(ni, nj);
            }
        }
    }

    static void afterYear() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isIce[i][j]) {
                    for (int d = 0; d < 4; d++) {
                        int ni = i + di[d];
                        int nj = j + dj[d];
                        if (!isIce[ni][nj]) {
                            map[i][j]--;
                            if (map[i][j] < 0) {
                                map[i][j] = 0;
                                break;
                            }
                        }
                    }
                }
            }
        }
        updateIce();
    }

    static void updateIce() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) isIce[i][j] = false;
            }
        }
    }

    static boolean emptyIce(boolean[][] isIce) {
        for (boolean[] il : isIce) {
            for (boolean ice : il) {
                if (ice) return false;
            }
        }
        return true;
    }
}
