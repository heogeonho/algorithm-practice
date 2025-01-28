import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1]; // 이친수 개수 저장 배열
        dp[1] = 1; // 1자리 이친수는 "1" 한 가지

        if (n > 1) {
            dp[2] = 1; // 2자리 이친수는 "10" 한 가지
        }

        // DP 점화식 적용
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}