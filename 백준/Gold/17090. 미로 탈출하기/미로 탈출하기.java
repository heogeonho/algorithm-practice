import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] di = {-1, 0, 1, 0}; // U R D L (상우하좌)
    static final int[] dj = {0, 1, 0, -1};
    static int N, M, cnt;
    static char[][] map;
    static boolean[][] dp; // 탈출 가능 여부 저장
    static boolean[][] isVisited; // DFS 방문 여부 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new boolean[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean dfs(int i, int j) {
        if (dp[i][j]) return true;
        if (isVisited[i][j]) return false;

        isVisited[i][j] = true; // 현재 방문한 경로 표시

        // 이동 방향 결정
        int dir = -1;
        switch (map[i][j]) {
            case 'U': dir = 0; break;
            case 'R': dir = 1; break;
            case 'D': dir = 2; break;
            case 'L': dir = 3; break;
        }

        int ni = i + di[dir];
        int nj = j + dj[dir];

        boolean canEscape = false;
        if (ni < 0 || ni >= N || nj < 0 || nj >= M) { // 미로 탈출 조건
            canEscape = true;
        } else {
            canEscape = dfs(ni, nj); // 다음 좌표 탐색
        }

        dp[i][j] = canEscape; // 결과 저장 (메모이제이션)
        return canEscape;
    }
}
