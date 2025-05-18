import java.io.*;
import java.util.*;

public class Main {
    static boolean[] v;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 양방향!!
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 방문에 순서가 있었음 -> 처음에 신경 안써서 틀림
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        v = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        v = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int node) {
        v[node] = true;
        sb.append(node).append(" ");
        for (int next : graph[node]) {
            if (!v[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append(" ");

            for (int next : graph[curr]) {
                if (!v[next]) {
                    v[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}