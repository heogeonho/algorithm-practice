import java.util.*;
class Solution {
	static ArrayList<String> results = new ArrayList<>();
	static boolean v[];

	static String[] solution(String[][] tickets) {
		v = new boolean[tickets.length];
		dfs(0, "ICN", "ICN", tickets);
		Collections.sort(results);

		return results.get(0).split(" ");
	}

	// 문자열로 path를 만들어내는 idea (단어와 관련된 dfs 문제랑 비슷하게 풀면 되는 문제)
	static void dfs(int depth, String now, String path, String[][] tickets){
		if (depth == tickets.length) {
			results.add(path);
			return;
		}
		for (int i = 0; i < v.length; i++) {
			// 현재 지역의 다음 지역 tickets[i][1] == 시작 자역 tickets[i][0]인 것 찾아서 탐색 돌리기, 방문처리도 고려
			if (now.equals(tickets[i][0]) && !v[i]) {
				v[i] = true;
				dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
				v[i] = false;
			}
		}
	}
}