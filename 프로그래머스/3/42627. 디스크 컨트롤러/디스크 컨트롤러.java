import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        // 모든 스코빌 지수를 우선순위 큐에 추가
        for (int sc : scoville) {
            pq.offer(sc);
        }

        // 가장 작은 값이 K 이상이 될 때까지 섞기
        while (pq.size() > 1 && pq.peek() < K) {
            int current = pq.poll();
            int next = pq.poll();
            int sum = current + next * 2;
            pq.offer(sum);
            answer++;
        }

        // 모든 요소가 처리된 후에도 가장 작은 값이 K보다 작으면 -1 반환
        if (pq.peek() < K) {
            return -1;
        }

        return answer;
    }
}