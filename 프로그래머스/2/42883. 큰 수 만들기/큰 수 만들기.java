import java.util.*; //StringBuilder sb = new StringBuilder()

import java.io.*;

class Solution { //숫자 num , 제거할 수 개수 k
    
    public String solution(String number, int k) {
        // String answer = "";
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        int len=number.length();
        
        for(int i=0;i< len;i++){
            
            char c = number.charAt(i);
            while(!stack.isEmpty() && k>0&&stack.peekLast() <c){
                
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        while(k>0){
            
            stack.removeLast();
            k--;
        } 
        StringBuilder answer =new StringBuilder();
        for(char c: stack){
            
            answer.append(c);
        }
        // number에서 k개의 수 제거 ->: 만들 수 있는 가장 큰 숫자를 문자열로 리턴 
         
        return answer.toString();
    }
}