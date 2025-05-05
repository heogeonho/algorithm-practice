import java.io.*;

// Bottom-Up 활용 DP
public class Main {
    static int[][] dp = new int[41][2]; // 0 호출 횟수, 1 호출 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기값 설정
        dp[0][0] = 1; 
        dp[0][1] = 0;
        dp[1][0] = 0; 
        dp[1][1] = 1;

        // DP
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.print(sb);
    }
}