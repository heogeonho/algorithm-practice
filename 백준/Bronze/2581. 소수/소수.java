import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j <= N; j += i) {
                isNotPrime[j] = true;
            }
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
