import java.io.*;
import java.util.*;

class Main {
    static final int MAX_RANGE = 100_001;
    static boolean[] v = new boolean[MAX_RANGE];
    static int K, N;

    // 최단 경로 문제라서 bfs 활용
    // 초반에 별 생각없이 dfs로 풀다가 아차 했던 문제 (dfs는 최단 시간인지 보장하기 어려움)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);
    }

    public static void bfs(int start) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0});
        v[start] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int depth = curr[1];

            if (x == K)  {
                System.out.println(depth);
                return;
            }

            if (x - 1 >= 0 && !v[x - 1]) {
                v[x - 1] = true;
                q.offer(new int[]{x - 1, depth + 1});
            }
            if (x + 1 < MAX_RANGE && !v[x + 1]) {
                v[x + 1] = true;
                q.offer(new int[]{x + 1, depth + 1});
            }
            if (x * 2 < MAX_RANGE && !v[x * 2]) {
                v[x * 2] = true;
                q.offer(new int[]{x * 2, depth + 1});
            }
        }
    }
}