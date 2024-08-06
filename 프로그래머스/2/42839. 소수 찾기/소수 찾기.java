import java.util.*;
import java.io.*;

class Solution {
    /*
	부분집합 구하기 알고리즘을 활용하여 만들 수 있는 수를 구한다
	
	위에서 구한 수를 int값으로 돌려 Set에 저장한다.
	
	해당 수에 대해 소수 찾기 로직을 적용한다
		제곱근 이하의 범위를 나누기 연산을 돌려
		나누어 떨어지면 다음 숫자로 넘어간다
	 */
	
	static HashSet<Integer> set;
	static boolean[] v=new boolean[7];
	
    public static int solution(String numbers) {
    	int answer=0;
    	set=new HashSet<>();
    	dfs(numbers, "", 0);
    	
    	for(Integer a: set) {
    		if (isPrime(a)) {
    			answer++;
    		}
    	}

        return answer;
    }
    

	// 모든 길이의 순열 구하기?
    // 매번 set에 저장하는 방식
    // 끝 자리까지 보면 종료
    static void dfs(String numbers, String str, int cnt) {
    	if(cnt>numbers.length()) {
    		return;
    	}
    	
    	for (int i=0; i<numbers.length(); i++) {
    		if(v[i]) continue;
    		v[i]=true;
    		set.add(Integer.parseInt(str+numbers.charAt(i)));
    		dfs(numbers, str+numbers.charAt(i), cnt+1);
    		v[i]=false;
    	}
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}