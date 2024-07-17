import java.util.*;
import java.io.*;


class Solution {
    public static int[] solution(int[] prices) {
    	Stack<int[]> stack=new Stack<>();
    	int len=prices.length;
    	int[] answer = new int[len];
    	
    	for(int i=0; i<len; i++) {	// 전체 prices 순회를 위한 반복문
    		
    		if(stack.isEmpty()) { 				// 비어있으면 값 넣고 다음 인덱스 처리
    			stack.push(new int[] {i, prices[i]});
    			continue;
    		}
    				
			while(stack.peek()[1]>prices[i]) { // 스택이 안비어있을때만 수행
				int[] tmp=stack.pop();
				answer[tmp[0]]=i-tmp[0];
				if(stack.isEmpty()) break;
			}
			stack.push(new int[] {i, prices[i]}); // 비교하고 결과값 산출 후 다음과정 넘어가기 전 push
    	}
   
    	int n= stack.size();
    	for (int i=0; i<n; i++) {	// push 과정 끝나고 남아있는 겂에 대한 처리
    		int[] tmp=stack.pop();
			answer[tmp[0]]=len-1-tmp[0];
    	}
        return answer;
    }
}