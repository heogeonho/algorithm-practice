import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int[] colors = new int[M];
        int sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
            sum += colors[i];
        }

        int K = Integer.parseInt(br.readLine());

        if (K > sum) {
            System.out.println("0.0");
            return;
        }

        // 전체 경우의 수: C(sum, K)
        double total = combination(sum, K);
        double findSameColor = 0.0;

        // 같은 색상에서만 뽑는 경우의 확률
        for (int i = 0; i < M; i++) {
            if (colors[i] >= K) {
                findSameColor += combination(colors[i], K);
            }
        }

        // 확률 계산
        System.out.printf("%.9f\n", findSameColor / total);
    }

    // 조합 C(n, r) = n! / (r!(n-r)!)
    public static double combination(int n, int r) {
        if (r > n) return 0.0;
        if (r == 0 || r == n) return 1.0;
        if (r > n - r) r = n - r; // C(n, r) == C(n, n-r)

        double result = 1.0;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
// 조합의 수학적 계산 잊고있었는데 다시 공부하게 되었던 문제
// 복잡한 계산이라면 한번더 쉽게 풀어서 처리할 생각을 해볼 것