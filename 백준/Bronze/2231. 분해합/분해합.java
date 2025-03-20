import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);
        
        // 분해합으로 입력을 만들 수 있는 값은 -> 결과 - 자리수 x 9로 판단
        int findRange = 9 * str.length();
        int startNum = num - findRange;
        
        // 분해합이 나올 수 있는 최대 범위에서 전체 순회
        int result = 0;
        for (int i = 0; i < findRange; i++) {
            if (Integer.parseInt(str) == calDSum(startNum+i)) {
                result = startNum+i;
                break;
            }
        }
        System.out.println(result);
    }
    
    // 분해합 함수
    public static int calDSum(int num) {
        String str = String.valueOf(num);
        for (char ch : str.toCharArray()) {
            num+= ch - '1' + 1;
        }
        return num;
    }
}