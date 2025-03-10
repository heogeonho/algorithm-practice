import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char temp = str.charAt(j);
                if (temp == 'W') board[i][j] = 1;
                else board[i][j] = 0;
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                findChess(i, j);
            }
        }
        System.out.println(min);

    }

    private static void findChess(int i, int j) {
        int case1Cnt = 0;
        int case2Cnt = 0;

        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                int expected = ((k + l) % 2 == 0) ? 1 : 0;
                if (board[i + k][j + l] != expected) case1Cnt++;

                expected = ((k + l) % 2 == 0) ? 0 : 1;
                if (board[i + k][j + l] != expected) case2Cnt++;
            }
        }
        min = Math.min(min, Math.min(case1Cnt, case2Cnt));
    }
}
