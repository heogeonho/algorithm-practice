import java.io.*;

public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 플로이드 워셜 알고리즘
        for (int k = 0; k < N; k++) { // 중간 노드
            for (int i = 0; i < N; i++) { // 출발 노드
                for (int j = 0; j < N; j++) { // 도착 노드
                    // 도달 가능한 경우 1
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int val : row) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}