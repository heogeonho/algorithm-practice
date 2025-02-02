import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = br.readLine();
        int len = input.length();
        int[] arr = new int[26];

        for (int i = 0; i < len; i++) {
            int index = input.charAt(i) - 'A';
            arr[index]++;
        }

        int oddIndex = -1;
        int oddCount = 0;

        // 홀수 개수 확인
        // * 홀수 개수 확인만 하면 되는 이유 -> 짝수 길이일때 홀수가 나오면 무조건 홀수 개수 2개됨
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
        }

        // 팰린드롬을 만들 수 없는 경우
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
        br.close();
    }
}