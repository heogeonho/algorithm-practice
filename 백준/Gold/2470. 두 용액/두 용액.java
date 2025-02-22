/*
결국 풀이법 본 문제
투포인터? 이분탐색? 좀더 이해가 필요할 것 같다
다양한 유형 더 풀어볼 것
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
용액의 특성
두 용액의 합 0에 가까운 특성값 찾기
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int[] result = new int[2];

        int start = 0;
        int end = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (start < end) {

            int abs = Math.abs(arr[start] + arr[end]);
            if (abs < min) {
                min = abs;
                result[0] = arr[start];
                result[1] = arr[end];
            }

            if ((arr[start] + arr[end]) > 0) {
                end--;
            } else if ((arr[start] + arr[end]) < 0) {
                start++;
            } else {
                break;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
