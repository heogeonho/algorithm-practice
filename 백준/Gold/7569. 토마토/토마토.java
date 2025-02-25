import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;     // 상자의 가로M, 상자의 세로N, 높이H
    static int[][][] map;
    static boolean[][][] v;

    static int[] di = {-1, 0, 1, 0, 0, 0}; //상우하좌 앞 뒤
    static int[] dj = {0, 1, 0, -1, 0, 0}; //상우하좌 앞 뒤
    static int[] dh = {0, 0, 0, 0, 1, -1}; //상우하좌 앞 뒤

    static ArrayDeque<int[]> q = new ArrayDeque<>(); // 가로 세로 높이 int[] 담는 큐

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        v = new boolean[H][N][M];

        // map
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[h][i][j] = input;
                    if (input == 1) {
                        q.offer(new int[]{h, i, j});
                        v[h][i][j] = true;
                    }
                }
            }
        }
        
        bfs();
        int answer = getAnswer();
        System.out.println(answer);
        br.close();
    }

    static int getAnswer() {
        int answer = Integer.MIN_VALUE;
        for (int h = 0; h < H; h++) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!v[h][i][j] && map[h][i][j] == 0) { //안익은 토마토가 있는경우
                        answer = -1;
                        return answer;
                    } else if (v[h][i][j]) { // 방문처리가 된 토마토 중 가장 큰 수
                        answer = Math.max(map[h][i][j], answer);
                    }
                }
            }
        }
        if (answer == 1) {
            return 0;
        }
        return answer - 1;
    }

    // 너비 우선 탐색
    static void bfs() {
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int hh = temp[0]; // 높이
            int ii = temp[1]; // N
            int jj = temp[2]; // M
            for (int d = 0; d < 6; d++) {
                int nh = hh + dh[d];
                int ni = ii + di[d];
                int nj = jj + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M && 0 <= nh && nh < H && !v[nh][ni][nj] && map[nh][ni][nj] != -1) {
                    v[nh][ni][nj] = true;
                    map[nh][ni][nj] = map[hh][ii][jj] + 1;
                    q.offer(new int[]{nh, ni, nj});
                }
            }
        }
    }
}