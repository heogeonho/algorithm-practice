import java.util.*;

class Solution {
    
	/*
	lost 체크
	일단 reserve 중 lost 해당 사람 있나 체크 후

	lost 작은번호부터 순회
	reserve에 번호 -1 & +1 체크

    체크하는 아이디어?
    ArrayList로 바꿔야 하나?
    그냥 단순 값 변경으로 체크하도록 처리
	 */

	static int solution(int n, int[] lost, int[] reserve) {
		// 작은 번호부터 처리하기 위해 sort
		Arrays.sort(lost);
		Arrays.sort(reserve);
        
        int loLen = lost.length;
        int reLen = reserve.length;
        
        int answer = n - loLen; //확정된 값은 미리 넣고 시작

		for(int i = 0; i < loLen; i++) {
			for(int j = 0; j < reLen; j++) {
				if(lost[i] == reserve[j]) {
					answer++;
					lost[i] = -1;
					reserve[j]= -1;
					break;
				}
			}
		}
		for(int i = 0; i < loLen; i++) {
			for(int j = 0; j < reLen;j++) {
				if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])) {
					answer++;
					reserve[j] = -1;
					break;
				}
			}
		}
		return answer;
	}
}