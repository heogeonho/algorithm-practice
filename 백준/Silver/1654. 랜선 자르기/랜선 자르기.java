import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] lines;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long low = 1, high = max + 1;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (isCountN(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println(low - 1);
    }

    static boolean isCountN(long len) {
        long cnt = 0;
        for (long l : lines) {
            cnt += l / len;
        }
        return cnt >= N;
    }
}