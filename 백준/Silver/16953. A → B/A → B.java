import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B));
    }

    static int bfs(long A, long B) {
        Deque<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{A, 1});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long num = current[0];
            int steps = (int) current[1];

            if (num == B) {
                return steps;
            }

            if (num * 2 <= B) {
                queue.offer(new long[]{num * 2, steps + 1});
            }
            if (num * 10 + 1 <= B) {
                queue.offer(new long[]{num * 10 + 1, steps + 1});
            }
        }

        return -1;
    }
}