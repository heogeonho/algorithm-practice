class Solution {
   		static int solution(String name) {

		int answer = 0;
		int move = name.length() - 1;
		for(int i=0; i<name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1); //위 아래 커서 char 의 특징 활용

			int idx = i + 1;
			while (idx < name.length() && name.charAt(idx) == 'A') {
				idx++;
			}

			move = Math.min(move, i * 2 + name.length() - idx);  // 오른쪽으로 갔다가 왼쪽으로 꺾기
			move = Math.min(move, (name.length() - idx) * 2 + i); // 왼쪽으로 갔다가 오른쪽으로 꺾기
		}

		return answer + move;
	}
}