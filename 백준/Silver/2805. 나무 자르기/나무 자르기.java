import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 1차 idea
    /*
    (1 ≤ N ≤ 1,000,000/ 1 ≤ M ≤ 2,000,000,000)
    나무들 (한줄)        / 필요 길이 7
    20 15 10 17

    리스트 max 추출 -> top 포인터
    2번째 큰 수 -> bottom 포인터

    총 합 변수와 (top-bottom) 합이
    필요길이보다 작으면 top 포인터 bottom 값으로 주고 bottom은 다음 수 찾기
    필요길이보다 크면 top 포인터 필요길이 - 총합변수 만큼 내린 값이 결과

    -> 아 근데 중복된 길이를 갖는 나무가 있으면...
    top - bottom or 포인터 업데이트 부터 문제가 있을지도...

    설정할 높이 15 (결과)
    */

    // 2차 idea (서칭 후)
    /*
    0, max 포인터 (bottom top)
    중간 값 -> 연산 후
    값이 목표보다 크면 bottom->중간 값 후 위 연산 진행
    값이 목표보다 작으면 top->중간 값 후 위 연산 진행
     */

    static int[] trees;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int topPointer = 0;
        int bottomPointer = 0;

        // N, M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long targetLen = Integer.parseInt(st.nextToken());

        // tree 배열
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            trees[i] = temp;
            topPointer = Math.max(topPointer, temp);
        }

        // 포인터 mid 추출 및 연산
        while (bottomPointer < topPointer) {
            int mid = (topPointer + bottomPointer) / 2;
            long treeSum = calTreeSum(mid);
            if (treeSum < targetLen) {
                topPointer = mid;
            } else {
                bottomPointer = mid + 1;
            }
        }
        System.out.println(bottomPointer - 1);
    }

    static long calTreeSum(int cut) {
        long ans = 0;
        for (int h : trees) {
            if (h - cut > 0) {
                ans += (h - cut);
            }
        }
        return ans;
    }
}
