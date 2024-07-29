import java.util.*;
import java.io.*;

class Solution {
		static int solution(int[] citations) {
		
		Integer[] arr=Arrays.stream(citations).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Collections.reverseOrder());
		
		int answer = 0;
		for(int i=0; i<arr.length; i++) {
			int h=i+1;
			if(h>arr[i]) {
				answer = h-1;
				break;
			}
      		if(i==arr.length-1) answer = h;
		}
		return answer;
    }
}