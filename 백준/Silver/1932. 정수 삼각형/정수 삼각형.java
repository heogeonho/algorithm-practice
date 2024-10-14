import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] tree = new int[n][1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            tree[i] = temp;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 맨 왼쪽 경로의 경우
                    tree[i][j] += tree[i - 1][j];
                } else if (j == i) {
                    // 맨 오른쪽 경로의 경우
                    tree[i][j] += tree[i - 1][j - 1];
                } else {
                    // 나머지 경우는 위의 두 경로 중 더 큰 값을 선택
                    tree[i][j] += Math.max(tree[i - 1][j - 1], tree[i - 1][j]);
                }
            }
        }

        // 마지막 행에서 최대값이 정답
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, tree[n - 1][i]);
        }
        System.out.println(maxSum);
    }
}
