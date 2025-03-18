import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        // 우선순위 큐? 말고 다른 방법 없나...?
        // 중요도 판단을 위해 우선순위 큐
        // 프린트 로직을 위해 일반 큐
        // 로 일단 풀어봄
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
             ArrayDeque<int[]> queue = new ArrayDeque<>();
             PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                int prior = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{k, prior});
                pq.offer(prior);
            }

            // 출력 순번
            int printOrder = 0;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int index = temp[0];
                int priority = temp[1];

                // 현재 문서가 중요도 가장 높은지 확인
                if (priority == pq.peek()) {
                    pq.poll(); // 가장 높은 중요도 제거
                    printOrder++;

                    // 목표 문서 -> 결과 출력
                    if (index == M) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                } else {
                    queue.offer(temp); 
                    // 중요도가 가장 높지 않다면 다시 큐에 삽입
                }
            }
        } 
        System.out.println(sb.toString());
        br.readLine();
    }
}