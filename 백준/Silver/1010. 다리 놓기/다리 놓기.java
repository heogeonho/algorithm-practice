import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(countBridgeWays(M, N)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int countBridgeWays(int n, int r) {

        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // 2번 성질
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        // 1번 성질
        return dp[n][r] = countBridgeWays(n - 1, r - 1) + countBridgeWays(n - 1, r);
    }
}
