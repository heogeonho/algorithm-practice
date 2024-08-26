class Solution {
    static int answer = 0;
    static int solution(int[] numbers, int target) {
		answer = 0;
		dfs(numbers, target, 0, 0);

		return answer;
	}

	static void dfs(int[] numbers, int target, int index, int sum) {
		if(index==numbers.length) {
			if(sum==target) answer+=1;
			return;
		}
		dfs(numbers, target, index+1, sum+numbers[index]);
		dfs(numbers, target, index+1, sum-numbers[index]);
	}
}