class Solution {
	static String solution(String number, int k) {
		int left=0;
		int right=k;
		int finalLen=number.length()-k;

		//반복 과정에서
		//왼쪽 포인트는 찾은 큰수 + 1
		//오른쪽 포인트는 왼쪽 + k
		StringBuilder answer = new StringBuilder();
		while(true) {
			char max=' ';
			int maxIdx=0;
			for(int i=left; i<=right; i++) {
				if(max<number.charAt(i)) {
					max = number.charAt(i);
					maxIdx = i;
				}
			}
			answer.append(number.charAt(maxIdx));

			k=k-(maxIdx-left);
			left=maxIdx+1;
			if(k==0) break;
			if(answer.length()==finalLen) break;
			right=left+k;
//			System.out.println("left:"+left+" right:"+right);
		}
//		System.out.println("left:"+left);
		if(answer.length()!=finalLen) {
			for (int i = left; i < number.length(); i++)
				answer.append(number.charAt(i));
		}
		return answer.toString();
	}
}