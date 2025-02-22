import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long maxLen = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            maxLen = Math.max(input, maxLen);
            arr[i] = input;
        }

        /*
        N개를 만들 수 있는 랜선의 최대 길이를 구하기
        -> 특정 길이 이하는 모두 충족인데 이분 탐색을 끝까지 진행해서 가장 큰 값 찾아야 해
        Upper Bound
         */

        // Upper Bound
        long lo = 0;
        long mid = 0;
        long hi = maxLen + 1;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (calN(mid, arr) >= N) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        System.out.println(lo - 1);
    }

    static int calN(long len, int[] arr) {
        int total = 0;
        for (int v : arr) {
            total += v / len;
        }
        return total;
    }
}
