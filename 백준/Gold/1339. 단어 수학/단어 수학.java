import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /*
    N개의 단어
    알파벳으로 이루어져 있고 0~9 숫자로 바꿔 합할 수 있음
    그 합이 최대가 될 수 있도록
    다른 알파벳은 다른 숫자가 되어야 함

    답을 본 문제
    조건인 높은 자리 요소, 빈도 높은 요소 두가지를 파악했으나 직접 배열에 넣고 찾아내려고 했다.
    코드 로직이 매우 복잡해져서 제한 시간 내 풀지 못함
    가중치라는 아이디어를 놓쳤다.

    아이디어만 잘 내면 코드 로직은 한없이 쉬워졌던 문제
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] strArr = new int[26];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                strArr[c - 'A'] += (int) Math.pow(10, (str.length() - j - 1));
            }
        }

        Arrays.sort(strArr);
        int idx = 25;
        int num = 9;
        int result = 0;
        while (strArr[idx] != 0) {
            result += strArr[idx] * num;
            idx--;
            num--;
        }
        System.out.println(result);
    }
}