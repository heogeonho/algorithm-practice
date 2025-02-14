import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            sb.append(nextPerm(str)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static String nextPerm(String str) {
        int len = str.length();
        // 뒤에서 탐색 시작
        // 다음 요소가 본인보다 큰 요소 찾기
        int idx = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (str.charAt(i) < str.charAt(i + 1)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return str;

        // 해당 요소보다 큰 요소를 뒤에서부터 찾기
        // 해당 요소와 자리 교체
        for (int i = len - 1; i > idx; i--) {
            if (str.charAt(i) > str.charAt(idx)) {
                str = swap(str, idx, i);
                break;
            }
        }

        // 그 뒤 요소들을 오름차순으로 교체 (reverse 수행하면 오름차순됨)
        int start = idx + 1;
        int end = len - 1;
        while (start < end) {
            str = swap(str, start++, end--);
        }
        return str;
    }

    static String swap(String str, int a, int b) {
        StringBuilder sb = new StringBuilder(str);

        char temp = sb.charAt(a);
        sb.setCharAt(a, sb.charAt(b));
        sb.setCharAt(b, temp);

        return sb.toString();
    }
}

// 비슷한 유형 문제 두번 풀면서 순열의 특성에 대해 이해하는 과정이 되었음