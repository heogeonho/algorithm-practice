import java.io.*;
import java.util.*;

// ArrayDeque를 활용해서 뒤집기 연산 없이 처리해보면 빠를 것이라 생각
// 플래그값 잘 활용해보기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            Deque<Integer> deque = new ArrayDeque<>();
            arrStr = arrStr.substring(1, arrStr.length() - 1);
            if (!arrStr.isEmpty()) {
                String[] elements = arrStr.split(",");
                for (String elem : elements) {
                    deque.add(Integer.parseInt(elem));
                }
            }

            boolean isReversed = false; // 뒤집힘 여부 파악 플래그 값
            boolean isError = false;

            for (char cmd : commands.toCharArray()) {
                if (cmd == 'R') {
                    isReversed = !isReversed;
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }
            
            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}