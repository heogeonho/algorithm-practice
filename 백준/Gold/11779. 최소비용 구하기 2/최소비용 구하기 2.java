import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.cost, n.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int n, m;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int[] prev; // 문제의 포인트 요소

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to   = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end   = Integer.parseInt(st.nextToken());

        prev = new int[n+1];
        dist = new int[n+1];
        Arrays.fill(prev, -1);
        Arrays.fill(dist, INF);
        dijkstra(start); 
        
        List<Integer> path = getPath(start, end);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n');
        sb.append(path.size()).append('\n');
        for (int city : path) {
            sb.append(city).append(' ');
        }
        System.out.println(sb);
    }

    static void dijkstra(int start) {
        dist[start] = 0;

        boolean[] v = new boolean[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int now = cur.index;

            if (v[now]) continue;
            v[now] = true;

            for(Node next : graph[now]) {
                if(v[next.index]) continue;
                int newCost = dist[now] + next.cost;

                if(newCost < dist[next.index]) {
                    dist[next.index] = newCost;
                    prev[next.index] = now;
                    pq.offer(new Node(next.index, newCost));
                }
            }
        }
    }

    static List<Integer> getPath(int start, int end) {
        List<Integer> path = new ArrayList<>();
        int cur = end;

        while (cur != -1) {
            path.add(cur);
            if (cur == start) break;
            cur = prev[cur];
        }

        Collections.reverse(path);
        return path;
    }
}