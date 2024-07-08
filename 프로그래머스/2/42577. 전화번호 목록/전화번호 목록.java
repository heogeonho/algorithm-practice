import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phoneBook) {
        HashMap<String,Integer> pMap = new HashMap<>();
    	for(String p:phoneBook) {
    		pMap.put(p, 0);
    	}
    	
    	for(int i=0; i<phoneBook.length; i++) {
    		for(int j=0; j<phoneBook[i].length(); j++) {
    			if(pMap.containsKey(phoneBook[i].substring(0, j))) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}