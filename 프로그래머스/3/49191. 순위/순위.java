import java.util.*;

class Solution {
     static List<Integer>[] g;
    static int N;
    static int[] cnt;

    static int solution(int n, int[][] results) {
        N = n + 1;
        g = new List[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] node : results) {
            g[node[0]].add(node[1]);
        }

        cnt = new int[N];
        for (int i = 1; i < N; i++) {
            boolean[] v = new boolean[N];
            bfs(i, v);
        }
        
        int answer = 0;
        for (int k : cnt) {
            if (k == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    static void bfs(int i, boolean[] v) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.offer(i);
        while (!q.isEmpty()) {
            int j = q.poll();
            for (int nj : g[j]) {
                if (!v[nj]) {
                    v[nj] = true;
                    cnt[i]++;
                    cnt[nj]++;
                    q.offer(nj);
                }
            }
        }
    }
}