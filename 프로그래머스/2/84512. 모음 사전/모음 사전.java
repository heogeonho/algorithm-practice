class Solution {
  	/*
		그래프 탐색 탐색 경로에서 전역 cnt변수 +1 반복해서 사전 순서 체크
		
		DFS 활용
		중복 허용 -> 방문처리 X
		문자열처리
		
		DFS(depth, str)
			-> 이건 고민중인건데 find 변수 하나 해줘서 재귀를 종료해야 하나 고민.
		
			IF 깊이 5글자 리턴 (우린 전역 cnt변수만 고려하기 때문에 리턴만 해줘도 ok)
			for (i -> 0~4) //알파벳 순회
			str + arr[i] (다음 dfs에 전달)
			cnt++;
			dfs(depth+1,str + arr[i],   )
	 */
	
	static String[] arr=new String[] {"A", "E", "I", "O", "U"};
	static int cnt=0;
	static boolean isFind=false;
	
    static int solution(String word) {
    	dfs(0, "", word);
        int answer = cnt;
        return answer;
    }
    
    static void dfs(int depth, String str, String word) {
    	if(str.length()==5 || isFind) return; //최종 길이가 되었거나 원하는 값 찾은 경우 종료

    	for(int i=0; i<5; i++) { //각 깊이별로 해당 자리 순회
//    		System.out.println("depth "+depth+" ___str="+(str+arr[i])+" / cnt="+cnt);
    		if(word.equals(str+arr[i])) { //값을 찾은 경우 최종 cnt++
    			isFind=true;
    			cnt++;
    		}
    		if(isFind) return; //추가적인 cnt 업데이트 안되도록 return
    		cnt++;
    		dfs(depth+1, str+arr[i], word); //다음 자리에 대한 dfs
    	}
    }
}