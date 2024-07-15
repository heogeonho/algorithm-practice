import java.util.*;
import java.io.*;

class Solution {
   public boolean solution(String s) {
		ArrayDeque<Character> stack=new ArrayDeque<>();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.push(s.charAt(i));				
			} else if(s.charAt(i)==')') {
				if(!stack.isEmpty()) {
					stack.pop();					
				} else return false;
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
}