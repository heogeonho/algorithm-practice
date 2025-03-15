import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        sb.append("<");

        int cnt = 0;
        while (!deque.isEmpty()) {
            cnt++;
            if (cnt % K == 0) {
                sb.append(deque.poll());
                if (!deque.isEmpty()) {
                    sb.append(", ");
                }
            } else {
                deque.offer(deque.poll());
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}