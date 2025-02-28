import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int[] di = {-1, 0, 1, 0};
    static final int[] dj = {0, 1, 0, -1};
    static int R, C;
    static char[][] map;
    static boolean [] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        map = new char[R][C];
        visited = new boolean[27];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
       
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int i, int j, int depth) {
        visited[map[i][j]-'A'] = true;
        max = Math.max(max, depth);
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < R && 0 <= nj && nj < C && !visited[map[ni][nj]-'A']) {
                dfs(ni, nj, depth + 1);
                visited[map[ni][nj]-'A'] = false;
            }
        }
    }
}
