import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] cards; 
    // 원래 pick 배열도 생성하려 했으나 합만 다루기 때문에 배열 없이 합만 유지하는 방식으로 해결해보고자 함
    static int sum = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬 (낮은 순으로 합을 구해나갈 수 있음)
        Arrays.sort(cards);

        pickCard(0, 0, 0);

        System.out.println(sum);
        br.close();
    }

    // 순조부 문제 생각해서 코드 아이디어 도출
    static void pickCard(int start, int cnt, int tempSum) {
        // 3개 픽스 완료시 합 비교 연산 수행
        // M 보다 작을 때만 동작하도록 조건 연산
        if (cnt == 3) {
            if (tempSum <= M) {
                sum = Math.max(sum, tempSum);
            }
            return;
        }
        for (int i = start; i < N; i++) {
            pickCard(i + 1, cnt + 1, tempSum + cards[i]);
        }
    }
}