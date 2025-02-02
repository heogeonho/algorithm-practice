import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] arr = new int[26];

        // 문자 개수 카운트 & 홀수 개 문자 체크
        int oddCount = 0, oddIndex = -1;
        for (char c : input.toCharArray()) {
            int idx = c - 'A';
            arr[idx]++;
            if (arr[idx] % 2 == 1) oddCount++;
            else oddCount--;
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 팰린드롬 구성
        StringBuilder firstHalf = new StringBuilder();
        char middleChar = '\0';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                char c = (char) (i + 'A');
                firstHalf.append(String.valueOf(c).repeat(arr[i] / 2));

                if (arr[i] % 2 == 1) middleChar = c;
            }
        }

        // 최종 결과 출력
        System.out.println(firstHalf.toString() + (middleChar != '\0' ? middleChar : "") + firstHalf.reverse().toString());
    }
}