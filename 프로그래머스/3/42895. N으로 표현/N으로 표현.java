import java.util.*;

public class Solution {
    public int solution(int N, int number) {
        // DP 리스트 생성
        List<Set<Integer>> dp = new ArrayList<>();

        // i번 사용해서 만들 수 있는 수
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }

       for (int i = 1; i < 9; i++) {
            int num = 0;
            int repeat = N;

            for (int j = 0; j < i; j++) {
                num = num * 10 + repeat;  // N을 이어 붙이기
            }

            dp.get(i).add(num);
        }

        // DP 계산
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i - j)) {
                        dp.get(i).add(x + y);
                        dp.get(i).add(x - y);
                        dp.get(i).add(x * y);
                        if (y != 0) {
                            dp.get(i).add(x / y);
                        }
                    }
                }
            }
            // 목표 숫자를 찾으면 바로 반환
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        // 8번 이하로 만들 수 없는 경우 -1 반환
        return -1;
    }
}
