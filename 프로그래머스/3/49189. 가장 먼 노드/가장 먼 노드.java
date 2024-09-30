import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static int N;
    static List<Integer>[] g;
    static boolean[] v;
    static int[] dist;
    static int maxDist = Integer.MIN_VALUE;

    static int solution(int n, int[][] edge) {
        N = n + 1;  // node: 1 ~ n

        // 인접 리스트
        g = new List[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] node : edge) {
            g[node[0]].add(node[1]);
            g[node[1]].add(node[0]);
        }

        v = new boolean[N];
        dist = new int[N];
        bfs(1);

        int answer = 0;
        for (int d : dist) {
            if (d == maxDist) {
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int i) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[i] = 0;
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            int ni = q.poll();
            for (int j : g[ni]) {
                if (!v[j]) {
                    v[j] = true;
                    dist[j] = dist[ni] + 1;
                    maxDist = Math.max(dist[j], maxDist);
                    q.offer(j);
                }
            }
        }
    }
}