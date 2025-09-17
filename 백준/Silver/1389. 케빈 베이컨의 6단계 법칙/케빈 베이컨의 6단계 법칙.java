import java.io.*;
import java.util.*;

// 양방향 그래프
// 최단거리
// 

class Main {
    static int N, M;
    static List<Integer>[] g;    // 친구 그래프
    static boolean[] v;             // 방문

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 유저의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        
        g = new ArrayList[N+1]; // 1 ~ N
        for(int i = 0; i <= N; i++) g[i] = new ArrayList<>(); // 1~N

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            g[from].add(to);
            g[to].add(from);
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 1; i <= N; i++) {
            v = new boolean[N+1];
            int kbNum = bfs(i);
            if(min > kbNum) {
                min = kbNum;
                result = i;
            }
        }
        System.out.println(result);
    }

    static int bfs(int i) {
        int res = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, 0});
        v[i] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int ci = curr[0];
            int depth = curr[1];
            for(int ni : g[ci]) {
                if(v[ni]) continue;
                q.offer(new int[] {ni, depth+1});
                v[ni] = true;
                res+=depth+1;
            }
        }
        return res;
    }
}