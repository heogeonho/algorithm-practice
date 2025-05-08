import java.io.*;
import java.util.*;

/*
파도반 수열
1번째 = 1
2번째 = 1
3번째 = 1
4번째 = 2
5번째 = 2
6번째 = 1번 + 5번
7번째 = 2번 + 6번
8번째 = 3번 + 7번
9번째 = 4번 + 8번
*/ 

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        
        // 초기값 설정
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;

        // 바텀업 방식으로 dp 배열 미리 채워넣기
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i-5] + dp[i-1];
        }

        // 테스트별로 채워넣은 dp 값 출력
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb.toString());
    }
}