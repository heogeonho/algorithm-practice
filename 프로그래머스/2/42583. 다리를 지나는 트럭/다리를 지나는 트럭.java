import java.util.*;
import java.io.*;

class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
    	ArrayDeque<Integer> q=new ArrayDeque<>();
    	q.offer(0);
    	int totalWeight=0;
    	int time=0;
    	int cnt=0; // 트럭이 전부 돌아왔는지 파악하기 위한 것
    	int num=0; // 어떤 인덱스의 트럭이 사용되는지 넣는 것
    	while(true) {
    		time++;
    		if(num<truck_weights.length) {
    			if(q.size()<bridge_length) {
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    					num++;
    				} else q.offer(0);
    			} 
    			
    			else if(q.size()==bridge_length) {
    				int k=q.poll();
    				totalWeight-=k;
    				if(k!=0) {
    					cnt++;
    					if(cnt==truck_weights.length) {
    						break;
    					}
    				}
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    					num++;
    				} else q.offer(0);
    			}
    		}
    		
    		else if(num==truck_weights.length-1) {
    			if(q.size()<bridge_length) {
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    				} else q.offer(0);
    			} 
    			
    			else if(q.size()==bridge_length) {
    				int k=q.poll();
    				totalWeight-=k;
    				if(k!=0) {
    					cnt++;
    					if(cnt==truck_weights.length) {
    						break;
    					}
    				}
    				if(totalWeight+truck_weights[num]<=weight) {
    					q.offer(truck_weights[num]);
    					totalWeight+=truck_weights[num];
    				} else q.offer(0);
    			}
    		}
    		
    		else {
    			
    			if(q.size()<bridge_length) {
    				q.offer(0);
    			} 
    			
    			else if(q.size()==bridge_length) {
    				int k=q.poll();
    				totalWeight-=k;
    				if(k!=0) {
    					cnt++;
    					if(cnt==truck_weights.length) {
    						break;
    					}
    				}
    				q.offer(0);
    			}		
    		}
    	}
        return time;
    }
}