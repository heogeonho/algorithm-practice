import java.util.*;

class Solution {
    	static int solution(int[] people, int limit) {
		ArrayList<Integer> arr=new ArrayList<>();
		for(int a:people) arr.add(a);
		arr.sort((o1, o2) -> Integer.compare(o1, o2));
		System.out.println(arr);

		int answer = 0;
		while(true) {
			int temp = arr.get(0);
			if(arr.size()==1) {
				answer++;
				break;
			}
			if(temp+arr.get(1)>limit) {
				arr.remove(0);
				answer++;
				continue;
			}
			for(int i=2; i<arr.size(); i++) {
				if(temp+arr.get(i)>limit) {
					arr.remove(i-1);
					arr.remove(0);
					answer++;
					break;
				}
			}
//			System.out.println(arr);
		}
		return answer;
	}
}