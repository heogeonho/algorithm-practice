import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
    	int pickNum=nums.length/2;
    	HashMap<Integer,Integer> hm = new HashMap<>(10);
    	
    	for(int n:nums) {
    		if(hm.containsKey(n)) {
    			int temp=hm.get(n);
    			hm.replace(n, temp++);
    		} else {
    			hm.put(n, 1);    			
    		}
    	}
    	if(hm.size()>pickNum) {
    		return pickNum;
    	}
    	return hm.size();
    }
}