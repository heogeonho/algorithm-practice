import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][][] v;
    static int[] di = new int[]{-1, 0, 1, 0};
    static int[] dj = new int[]{0, 1, 0, -1};
    
    static class Node {
        int i, j, broken, dist;

        Node(int i, int j, int broken, int dist) {
            this.i = i;
            this.j = j;
            this.broken = broken;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int i, int j) {
        v[i][j][0] = true;
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(i, j, 0, 1));

        while (!q.isEmpty()) {
            Node ij = q.poll();
            if (ij.i == N - 1 && ij.j == M - 1) {
                return ij.dist;
            }
            i = ij.i;
            j = ij.j;
            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    if (map[ni][nj] == 0 && !v[ni][nj][ij.broken]) {
                        v[ni][nj][ij.broken] = true;
                        q.offer(new Node(ni, nj, ij.broken, ij.dist + 1));
                    }
                    if (map[ni][nj] == 1 && !v[ni][nj][1] && ij.broken == 0) {
                        v[ni][nj][1] = true;
                        q.offer(new Node(ni, nj, 1, ij.dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}
