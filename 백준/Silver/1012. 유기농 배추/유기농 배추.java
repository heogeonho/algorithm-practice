import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static final int[] di = new int[] {-1,0,1,0}; //상우하좌
    static final int[] dj = new int[] {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        // test case T회 반복
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 개수
            
            // 배추 위치 map에 할당
            map = new int[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            v = new boolean[N][M];
            
            // map 순회 및 배추 dfs 영역 cnt
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if (map[i][j]==1 && !v[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb.toString());
    }

    // dfs 수행을 위한 메서드
    static void dfs(int i, int j) {
        v[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj] && map[ni][nj]==1) {
                v[ni][nj] = true;
                dfs(ni,nj);
            }
        }
    }
}