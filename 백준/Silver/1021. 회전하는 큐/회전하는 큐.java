import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 큐의 크기
        int M = Integer.parseInt(st.nextToken()); // 뽑는 수의 개수

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int[] idx = new int[M+1]; // 인덱스 1부터 값 활용
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            idx[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i <= M; i++) {
            int target = idx[i];

            // 현재 큐에서 target의 위치 확인
            int pos = 0;
            for (int val : q) {
                if (val == target) break;
                pos++;
            }

            int size = q.size();

            // 앞에서 꺼내는 게 빠르면 왼쪽 회전
            if (pos <= size / 2) {
                while (q.peek() != target) {
                    q.offerLast(q.pollFirst());
                    count++;
                }
            } else {
                // 뒤에서 꺼내는 게 빠르면 오른쪽 회전
                while (q.peek() != target) {
                    q.offerFirst(q.pollLast());
                    count++;
                }
            }

            q.poll(); // target 꺼내기
        }

        System.out.println(count);
    }
}