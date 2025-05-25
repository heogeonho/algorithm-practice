import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] v;
    static int[][] dist;
    static int[] di = new int[] {-1, 0, 1, 0};
    static int[] dj = new int[] {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);

        map = new int[n][m];
        dist = new int[n][m];
        v = new boolean[n][m];
        int targetX = -1;
        int targetY = -1;

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(row[j]);
                if (map[i][j] == 2) {
                    targetY = i;
                    targetX = j;
                }
            }
        }

        bfs(targetY, targetX);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    sb.append("0 ");
                } else if (!v[i][j]) {
                    sb.append("-1 ");
                } else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] ij = new int[] {i, j};
        q.offer(ij);
        v[i][j] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int ci = curr[0];
            int cj = curr[1];
            for(int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(0<=ni&&ni<n && 0<=nj&&nj<m && !v[ni][nj] && map[ni][nj]==1) {
                    v[ni][nj] = true;
                    dist[ni][nj] = dist[ci][cj] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }
}