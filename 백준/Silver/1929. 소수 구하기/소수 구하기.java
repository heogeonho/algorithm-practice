import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // M이상 N이하의 소수
        // 1 ≤ M ≤ N ≤ 1,000,000
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] notPrime = new boolean[N+1];
        notPrime[0] = notPrime[1] = true;

        // 에라토스테네스의 채
        // 잘 기억하고 있을 부분은 범위! 전체 범위의 루트 만큼만 하면 됨
        for (int i = 2; i * i <= N; i++) {
            // 이미 걸러진 수는 패스
            if(notPrime[i]) continue; 
            
            // 소수 발견 -> 이후 합성수 필터링
            int cnt = 2;
            int p = i * cnt;
            while (p <= N) {
                notPrime[p] = true;
                cnt++;
                p = i * cnt;
            }
        }

        for (int i = M; i <= N; i++) {
            if(notPrime[i]) continue;
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}

// 확정적인 범위가 있고 소수 여부임을 미리 세팅하고 풀 수 있는 문제에서 활용하면 좋을 듯 하다.