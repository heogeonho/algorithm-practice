import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] v;
    static final int[] di = new int[] {-1, 0, 1, 0};
    static final int[] dj = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        v = new boolean[N][M];
        int si = 0;
        int sj = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = str.charAt(j);
                // 시작 위치 저장
                if (temp == 'I') {
                    si = i;
                    sj = j;
                }
                map[i][j] = temp;
            }
        }
        // 너비우선탐색 활용
        int res = bfs(si, sj);
        if(res!=0) System.out.println(res);
        else System.out.println("TT"); // 0일 경우 TT 출력
    }

    // bfs 탐색 활용
    static int bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        v[i][j] = true;
        
        int res = 0;
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            for(int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M && !v[ni][nj] && map[ni][nj]!='X') { // 벽'X' 추가 처리
                    if(map[ni][nj]=='P') res++;
                    q.offer(new int[] {ni, nj});
                    v[ni][nj] = true;
                }
            }
        }
        return res;
    }

}