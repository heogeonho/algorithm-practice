import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Node>[] g;
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    static class Node {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        g = new List[N + 1];
        for (int i = 0; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) { 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            g[from].add(new Node(to, weight));
            g[to].add(new Node(from, weight));
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        maxDist = 0;
        visited = new boolean[N + 1];
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist) {
        visited[node] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        for (Node next : g[node]) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.weight);
            }
        }
    }
}