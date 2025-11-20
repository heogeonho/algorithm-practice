import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[2 * F + 1];
            size = new int[2 * F + 1];

            for (int i = 1; i <= 2 * F; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            Map<String, Integer> nameToId = new HashMap<>();
            int setId = 1;

            for(int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();

                if (!nameToId.containsKey(p1)) nameToId.put(p1, setId++);
                if (!nameToId.containsKey(p2)) nameToId.put(p2, setId++);
                
                int a = nameToId.get(p1);
                int b = nameToId.get(p2);
                
                int netSize = union(a, b);
                sb.append(netSize).append("\n");
            }
        }
        System.out.println(sb.toString());
    }    

    public static int find(int x) {
        if (parent[x] == x) {
             return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return size[rootA];
        }

        parent[rootA] = rootB;
        size[rootB] += size[rootA];
        return size[rootB];
    }
}