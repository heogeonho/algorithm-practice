import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int w : works) pq.add(w);
        
        for (int i = 0; i < n; i++) {
            int tmp = pq.poll() - 1;
            if(tmp > 0) pq.add(tmp);
            if(pq.isEmpty()) break;
        }
        
        while(!pq.isEmpty()) {
            int k = pq.poll();
            answer += k * k;
        }
        return answer;
    }
}