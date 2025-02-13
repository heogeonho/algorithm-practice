import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000007;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int maxN = 2500; // 짝수 케이스만 처리
        precomputeDP(maxN);

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        while (T-- > 0) {
            int L = Integer.parseInt(br.readLine()); // 길이 L 입력
            if (L % 2 == 1) {
                sb.append("0\n"); // 홀수 길이의 올바른 괄호 문자열은 존재할 수 없음
            } else {
                sb.append(dp[L / 2]).append("\n"); // dp[n] → L=2n이므로 dp[L/2] 사용
            }
        }
        System.out.print(sb);
    }

    // DP 테이블
    private static void precomputeDP(int maxN) {
        dp = new long[maxN + 1];
        dp[0] = 1; // 기저 조건

        // (X)Y 형태로 X*Y 모든 경우 더하기 라고 함
        for (int n = 1; n <= maxN; n++) {
            for (int i = 0; i < n; i++) {
                dp[n] = (dp[n] + dp[i] * dp[n - 1 - i]) % MOD;
            }
        }
    }
}

// while (T-- > 0): T가 0보다 클 때 반복 실행하는 while 루프 후위 연산자 활용 새로 배움
// DP 는 아직 많이 부족한 상태