import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] rope = new int[T];

        for (int i = 0; i < T; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        int max = 0;
        for (int i = T; i > 0; i--) {
            max = Math.max(max, rope[i-1] * (T - i + 1)); // 최댓값 갱신
        }
        System.out.println(max);
    }
}