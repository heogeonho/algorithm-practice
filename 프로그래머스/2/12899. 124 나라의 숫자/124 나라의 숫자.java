class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] arr = {"4", "1", "2"};
        while (n > 0) {
            int temp = n % 3;
            n = n / 3;
            if (temp == 0) {
                n--;
            }
            sb.insert(0, arr[temp]);
        }
        
        return sb.toString();
    }
}

// sb.insert(0, arr[temp]); 
// StringBuilder를 다루는 방법을 다채롭게 알아둬야겠다..
// 숫자 연산으로 풀어내는 역량이 부족하다.