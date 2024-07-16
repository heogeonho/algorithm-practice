import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
    	
    	ArrayDeque<int[]> q=new ArrayDeque<>();
    	
    	// 인덱스와 해당 자리의 값을 큐에 넣는 로직
    	for(int i=0; i<priorities.length; i++) {
    		q.offer(new int[] {i, priorities[i]});
    	}
    	
    	// 우선순위별로 정렬해서 값 꺼내기 위해 배열 정렬
    	Arrays.sort(priorities);
    	
    	int cnt=0;
    	
    	// 뽑아야 하는 총 길이 반복 (값 하나하나 꺼내기 위한 반복)
    	for(int i=priorities.length-1; i>=0; i--) {
    		int find = priorities[i]; //찾아야 하는 값 (우선순위 높은 순)
    	
    		//그때그때 size 반복으로 원하는 숫자 찾아내기
    		for(int j=0; j<q.size(); j++) {
    			int[] idxVal=q.poll();
    			
    			if(idxVal[1]==find) { //찾았으면 종료
    				cnt++;
    				if(idxVal[0]==location) return cnt;
    				break;
    			}
    			q.offer(idxVal);
    		}
    	}
    	return 0;
    }
}