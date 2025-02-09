import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Integer[] rope = new Integer[T];

        for (int i = 0; i < T; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, (o1, o2) -> o2 - o1);

        int max = 0;
        for (int i = 0; i < T; i++) {
            max = Math.max(max, rope[i] * (i + 1)); // 최댓값 갱신
        }
        System.out.println(max);
    }
}