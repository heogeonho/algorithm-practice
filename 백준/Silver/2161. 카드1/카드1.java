import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int i = 1;
        while (!queue.isEmpty()) {
            int k = queue.remove();
            if (i % 2 == 0) {
                queue.add(k);
            } else {
                System.out.print(k+" ");
            }
            i++;
        }
    }
}