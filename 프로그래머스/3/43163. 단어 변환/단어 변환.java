import java.util.*;
class Solution {
	static ArrayDeque<Integer> dq=new ArrayDeque<>();
	static boolean[] v;
	static int[] route;
	static int solution(String begin, String target, String[] words) {
		v=new boolean[words.length];
		route=new int[words.length];

		// target 값이 없으면 무조건 0
		if(!Arrays.asList(words).contains(target)) {
			return 0;
		}
		// 첫 탐색은 먼저 dq에 넣고 시작 [index]
		for (int k=0; k<words.length; k++) {
			if(!v[k] && canConvert(begin, words[k])) {
				v[k]=true;
				route[k]=1;
				if(words[k].equals(target)) {
					return route[k];
				}
				dq.offer(k);
			}
		}
		return bfs(target, words);
	}

	static int bfs(String target, String[] words) {

		while(!dq.isEmpty()) {
			int now = dq.poll();
			for (int k=0; k<words.length; k++) {
				if(!v[k] && canConvert(words[now], words[k])) {
					v[k]=true;
					route[k]=route[now]+1;
					if(words[k].equals(target)) {
						return route[k];
					}
					dq.offer(k);
				}
			}
		}
		return 0;
	}

	static boolean canConvert(String word1, String word2){
		int diffCnt = 0;
		for (int i = 0; i<word1.length(); i++){
			if (word1.charAt(i) != word2.charAt(i)){
				diffCnt++;
			}
		}
		return diffCnt ==1;
	}
}