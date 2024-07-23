import java.util.*;
import java.io.*;

class Solution {
static HashMap<Integer, Integer> map=new HashMap<>();
	
	
    static int[] solution(String[] operations) {
    	StringTokenizer st=null;
    	
		PriorityQueue<Integer> maxPQ=new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minPQ=new PriorityQueue<>();
    	
    	for(int j=0; j<operations.length; j++) {
			st=new StringTokenizer(operations[j]," ");
			String oper=st.nextToken();
			
			if(oper.equals("I")) {
				int num=Integer.parseInt(st.nextToken());
				maxPQ.offer(num);
				minPQ.offer(num);
				map.put(num, map.getOrDefault(num, 0) + 1);	
			} 

			else  {
				int type=Integer.parseInt(st.nextToken());
				if(map.size()==0) continue;
				if(type==-1) {
					removeNum(minPQ);
				} else if(type==1) {
					removeNum(maxPQ);
				}
			}
		}
    	int[] answer=new int[2];
    	if(map.size()==0) {
			return answer;
		} else {
			int res=removeNum(maxPQ);
			answer[0]=res;
			if(map.size()!=0) res=removeNum(minPQ);
			answer[1]=res;
		}
       
        return answer;
    }
    
    static int removeNum(PriorityQueue<Integer> pq) {
		int value=0;
		while(true) {
			value=pq.poll();
			int cnt=map.getOrDefault(value, 0);
			if(cnt==0) continue;
			if(cnt==1) map.remove(value);
			else {
				map.put(value, cnt-1);
			}
			break;
		}
		return value;
	}
}