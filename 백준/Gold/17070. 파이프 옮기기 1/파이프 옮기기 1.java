import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] map;

    static final int[] di = new int[] {0, 1, 1}; // 우 우하 하
    static final int[] dj = new int[] {1, 1, 0};

    static int routeCnt;

    // 파이프 이동 가능 케이스
    // (1) 가로 -> 우 우하
    // (2) 대각선 -> 우 우하 하
    // (3) 세로 -> 우하 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        System.out.println(routeCnt);
    }


    static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 1, 0}); //
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int ci = curr[0];
            int cj = curr[1];
            int cc = curr[2];

            if(cc==0) { // 가로
                for(int i = 0; i < 2; i++) {
                    int ni = ci+di[i];
                    int nj = cj+dj[i];

                    if(ni<N && nj<N && map[ni][nj]!=1) {
                        if(i==1) {
                            if(map[ni-1][nj]==1 || map[ni][nj-1]==1 || map[ni][nj]==1) continue;
                        }
                        if(ni==N-1 && nj==N-1) {
                            routeCnt++;
                        } else {
                            q.offer(new int[] {ni, nj, i});
                        }
                    }
                }
            } else if (cc==1) { // 대각선
                for(int i = 0; i < 3; i++) {
                    int ni = ci+di[i];
                    int nj = cj+dj[i];
                    if(ni<N && nj<N && map[ni][nj]!=1) {
                        if(i==1) {
                            if(map[ci][nj]==1 || map[ni][cj]==1 || map[ni][nj]==1) continue;
                        }
                        if(ni==N-1 && nj==N-1) {
                            routeCnt++;
                        } else {
                            q.offer(new int[] {ni, nj, i});
                        }
                    }
                }
            } else { // 세로
                for(int i = 1; i < 3; i++) {
                    int ni = ci+di[i];
                    int nj = cj+dj[i];
                    if(ni<N && nj<N && map[ni][nj]!=1) {
                        if(i==1) {
                            if(map[ci][nj]==1 || map[ni][cj]==1 || map[ni][nj]==1) continue;
                        }
                        if(ni==N-1 && nj==N-1) {
                            routeCnt++;
                        } else {
                            q.offer(new int[] {ni, nj, i});
                        }
                    }
                }
            }
        }
    }

}