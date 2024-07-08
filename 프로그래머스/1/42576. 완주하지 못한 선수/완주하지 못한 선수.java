import java.util.*;
import java.io.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
    	HashMap<String,Integer> pMap = new HashMap<>();
    	for(String p:participant) {
    		if(pMap.containsKey(p)) {
    			int temp=pMap.get(p);
    			pMap.put(p, temp+1);
    		} else pMap.put(p, 1);
    	}
    	
    	for(String c:completion) {
    		if(pMap.get(c)==1) {
    			pMap.remove(c);
    		} else {
    			int temp=pMap.get(c);
    			pMap.put(c, temp-1);    		
    		}
    	}
    	
    	for(String key:pMap.keySet()) {
    		return key;
    	}
    	return null;
    }
}