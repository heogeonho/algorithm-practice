import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<Integer>[] graph;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }

        bfs(X);

        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(result);
            for (int city : result) {
                System.out.println(city);
            }
        }
    }

    static void bfs(int start) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        
        // 값 2개 저장해서 dist 활용하기
        queue.offer(new int[]{start, 0}); 
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int city = current[0];
            int dist = current[1];

            if (dist == K) {
                result.add(city);
            }

            if (dist > K) continue; 
            // dist > K 더 할 필요 없음

            for (int next : graph[city]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, dist + 1});
                }
            }
        }
    }
}