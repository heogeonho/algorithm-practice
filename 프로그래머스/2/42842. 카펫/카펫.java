class Solution {
  static int[] solution(int brown, int yellow) {
		int num=1; // 노란색의 세로 길이로 생각
		int[] answer = new int[2];
		while (num<=Math.sqrt(yellow)) {
			if(yellow%num==0) {
				if((num*2) + ((yellow/num)*2) + 4 == brown) {
					answer[1] = num+2;
					answer[0] = (yellow/num) + 2;
					break;
				}
			}
			num++;
		}
		return answer;
	}
}