import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int count = 1; // 횟수 카운트
        // 남은 갯수 1개일 때까지 반복
        while (queue.size() > 1) {
            if (count % 2 == 1) {
                queue.poll();
            } else {
                queue.offer(queue.poll());
            }
            count++;
        }

        System.out.println(queue.poll());
        br.close();
    }
}