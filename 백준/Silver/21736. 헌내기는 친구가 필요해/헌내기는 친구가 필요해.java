import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] v;
    static int[] di = new int[]{-1, 0, 1, 0};
    static int[] dj = new int[]{0, 1, 0, -1};
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        v = new boolean[N][M];

        int xi = 0;
        int yj = 0;

        for (int i = 0; i < N; i++) {
            String stLine = br.readLine();
            for (int j = 0; j < M; j++) {
                char value = stLine.charAt(j);
                map[i][j] = value;
                if (value == 'I') {
                    xi = i;
                    yj = j;
                }
            }
        }

        dfs(xi, yj);

        if (result != 0) {
            System.out.println(result);
        } else {
            System.out.println("TT");
        }
    }

    static void dfs(int i, int j) {
        v[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < M && !v[ni][nj] && map[ni][nj] != 'X') {
                if (map[ni][nj] == 'P') {
                    result++;
                }
                dfs(ni, nj);
            }
        }
    }
}
