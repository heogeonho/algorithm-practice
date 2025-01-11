import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n, m;
    static char[][] floor;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = br.readLine().split(" ");
        n = Integer.parseInt(dimensions[0]); // 행
        m = Integer.parseInt(dimensions[1]); // 열

        floor = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                floor[i][j] = row.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j, floor[i][j]);
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y, char type) {
        visited[x][y] = true;

        if (type == '-') { // 가로로 탐색
            int ny = y + 1;
            if (ny < m && !visited[x][ny] && floor[x][ny] == '-') {
                dfs(x, ny, type);
            }
        } else if (type == '|') { // 세로로 탐색
            int nx = x + 1;
            if (nx < n && !visited[nx][y] && floor[nx][y] == '|') {
                dfs(nx, y, type);
            }
        }
    }
}