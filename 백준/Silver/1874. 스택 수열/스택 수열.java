import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // 만들어야 하는 수열
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int current = 1; // 자연수 1부터 시작
        boolean possible = true; // 가능 여부 처리를 위한 변수

        // 수열의 숫자를 차례로 찾아야 하니 순회
        for (int target : arr) {

            // 찾을 수열의 숫자보다 작으면 스택에 push
            // 아닐 경우는 꺼내서 비교 (target이 아니라면 NO)
            while (current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}