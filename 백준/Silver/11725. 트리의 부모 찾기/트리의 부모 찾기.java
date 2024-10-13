import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] v;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        g = new ArrayList[N + 1];
        v = new boolean[N + 1];
        result = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer((br.readLine()));
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            g[i1].add(i2);
            g[i2].add(i1);
        }

        bfs();
        
        for (int i = 2; i < N + 1; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb.toString());
        
        br.close();
    }

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        v[1] = true;
        q.offer(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nNode : g[node]) {
                if (!v[nNode]) {
                    v[nNode] = true;
                    result[nNode] = node;
                    q.offer(nNode);
                }
            }
        }
    }
}
