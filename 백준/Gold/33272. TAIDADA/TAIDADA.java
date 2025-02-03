import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        /*
        1 이상 M 이하의 서로 다른 정수 N개를 나열하여 다음 조건을 만족하는 수열 A
         */
        List<Integer> sequence = new ArrayList<>();
        Set<Integer> excluded = new HashSet<>();

        for (int num = 1; num <= M && sequence.size() < N; num++) {
            if (excluded.contains(num)) continue; // 제외된 숫자는 건너뜀
            sequence.add(num);
            excluded.add(num ^ K); // 현재 선택된 숫자의 XOR 금지 숫자 추가
        }

        if (sequence.size() == N) {
            for (int num : sequence) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("-1");
        }

    }
}