import java.util.*;
import java.io.*;

class Solution {
		static String solution(int[] numbers) {
		int len=numbers.length;
		
		// String 배열 생성
		String[] strings=new String[len];
		for(int i=0; i<len; i++) {
			strings[i]=String.valueOf(numbers[i]);
		}
		
		// Stirng 배열에 대한 정렬
		Arrays.sort(strings, (o1, o2)-> (o2 + o1).compareTo(o1 + o2));
		
		if(strings[0].equals("0")) return "0";
		
        StringBuilder answer=new StringBuilder();
		for(int i=0; i<len; i++) {
			answer.append(strings[i]);
		}
		
        return answer.toString();
    }
}