import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static final int[] di = {-1, 0, 1, 0}; //상우하좌 (시계방향)
    static final int[] dj = {0, 1, 0, -1}; //상우하좌
    static int M, N, K, cnt;
    static int[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        v = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int m = y1; m < y2; m++) {
                for (int n = x1; n < x2; n++) {
                    map[m][n] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !v[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }

        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for (int k : result) {
            sb.append(k).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int size = 1;
        v[i][j] = true;
        q.offer(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < M && 0 <= nj && nj < N && !v[ni][nj] && map[ni][nj] == 0) {
                    size++;
                    v[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        return size;
    }
}
