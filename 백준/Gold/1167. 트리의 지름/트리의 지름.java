import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<int[]>[] tree;
    static boolean[] v;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        tree = new List[V + 1];
        for (int i = 0; i <= V; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new int[]{to, weight});
                tree[to].add(new int[]{from, weight});
            }
        }

        v = new boolean[V + 1];
        dfs(1, 0);

        v = new boolean[V + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist) {
        v[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        for (int[] edge : tree[node]) {
            int nextNode = edge[0];
            int weight = edge[1];
            if (!v[nextNode]) {
                dfs(nextNode, dist + weight);
            }
        }
    }
}
