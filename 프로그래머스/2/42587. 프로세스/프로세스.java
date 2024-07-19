import java.util.*;

class Solution {
	public int solution(int[] priorities, int location) {
		ArrayDeque<int[]> deque = new ArrayDeque<>();
		for (int i = 0; i < priorities.length; i++) {
			deque.offer(new int[] { priorities[i], i });
		}
		int count = 0;
		while (!deque.isEmpty()) {
			int[] current = deque.poll();
			boolean hasHigherPriority = false;
			for (int[] doc : deque) {
				if (doc[0] > current[0]) {
					hasHigherPriority = true;
					break;
				}
			}
			if (hasHigherPriority) {
				deque.offer(current);
			} else {
				count++;
				if (current[1] == location) {
					return count;
				}
			}
		}
		return -1;
	}
}