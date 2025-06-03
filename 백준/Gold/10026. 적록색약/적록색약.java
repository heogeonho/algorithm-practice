import java.io.*;
import java.util.*;

class Main {

    static int N;
    static char[][] map;
    static boolean[][] v;
    static boolean[][] vRG;
    static int cnt, cntRG = 0;

    static final int[] di = new int[] {-1, 0, 1, 0};
    static final int[] dj = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        v = new boolean[N][N];
        vRG = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 방문 x인 경우 알파벳 인식
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!v[i][j])  {
                    dfs(i, j, map[i][j]);
                    cnt++;
                }
                if(!vRG[i][j]) {
                    dfsRG(i, j, map[i][j]);
                    cntRG++;
                }
            }
        }

        System.out.print(cnt+" "+cntRG);
    }

    static void dfs(int i, int j, char rgb) {
        v[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(0<=ni&&ni<N && 0<=nj&&nj<N && !v[ni][nj] && map[ni][nj] == rgb) {
                dfs(ni,nj,rgb);
            }
        }
    }

    static void dfsRG(int i, int j, char rgb) {
        vRG[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if(rgb == 'R' || rgb == 'G') {
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !vRG[ni][nj]) {
                    if(map[ni][nj] == 'R' || map[ni][nj] == 'G') {
                        dfsRG(ni,nj,rgb);
                    }
                }
            }
            else {
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !vRG[ni][nj] && map[ni][nj] == rgb) {
                    dfsRG(ni,nj,rgb);
                }
            }

        }
    }
}