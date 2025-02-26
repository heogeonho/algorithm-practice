import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시간 복잡도에 대한 우려가 있었으나
숫자 범위가 (index 범위) 크지 않아 괜찮았던 문제
 */

public class Main {

    static int[] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (findGood(i)) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 각 인덱스 타겟마다 좋은 수 인지 판단하는 함수
    static boolean findGood(int idx) {
        int target = arr[idx]; // 우리가 찾고자 하는 좋은 수
        int start = 0; // 시작점
        int end = N - 1; // 끝점

        while (start < end) {
            if (start == idx) {
                start++;
                continue;
            }
            if (end == idx) {
                end--;
                continue;
            }

            int sum = arr[start] + arr[end];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}