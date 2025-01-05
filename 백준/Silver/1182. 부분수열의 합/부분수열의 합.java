import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, count;
    static int[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        findSubsets(0, 0);

        // S가 0일 경우 공집합을 제외
        if (S == 0) count--;
        System.out.println(count);
    }

    static void findSubsets(int index, int sum) {
        if (index == N) {
            if (sum == S) count++;
            return;
        }

        // 현재 원소를 포함하는 경우
        findSubsets(index + 1, sum + numbers[index]);

        // 현재 원소를 포함하지 않는 경우
        findSubsets(index + 1, sum);
    }
}