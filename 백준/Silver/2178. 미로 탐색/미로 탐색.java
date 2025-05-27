import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static char[][] map;
    static boolean[][] v;
    static int[] di = new int[] {-1, 0, 1, 0};
    static int[] dj = new int[] {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        map = new char[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
            }
        }
        
        System.out.println(bfs(0, 0));
    }

    static int bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[] ij = new int[] {i, j, 1};
        q.offer(ij);
        v[i][j] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int ci = curr[0];
            int cj = curr[1];
            int cd = curr[2];

            for(int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj] && map[ni][nj]=='1') {
                    if(ni == N-1 && nj == M-1) {
                        return cd+1;
                    }
                    v[ni][nj] = true;
                    q.offer(new int[]{ni, nj, cd+1});
                }
            }
        }
        return -1;
    }
}