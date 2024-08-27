import java.util.*;

class Solution {
static boolean[] v;
	static int solution(int n, int[][] computers) {
		v =new boolean[n];
		int answer = 0;

		for(int i=0; i<n; i++) {
			if(!v[i]) {
				bfs(i, n, computers);
				answer+=1;
			}
		}
		return answer;
	}

	private static void bfs(int i, int n, int[][] computers) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(i);
		v[i] = true;

		while(!dq.isEmpty()) {
			int node = dq.poll();

			for (int k = 0; k < n; k++) {
				if (computers[node][k] == 1 && !v[k]) {
					dq.offer(k);
					v[k] = true;
				}
			}
		}
    }
}