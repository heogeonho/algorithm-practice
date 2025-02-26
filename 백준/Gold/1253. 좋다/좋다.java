import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*

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

    static boolean findGood(int idx) {
        int target = arr[idx]; // 우리가 찾고자 하는 좋은 수
        int start = 0;
        int end = N - 1;

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

