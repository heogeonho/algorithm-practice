import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
크기가 N인 수열
수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
그러한 수가 없는 경우에 오큰수는 -1이다.

A = [3, 5, 2, 7]인 경우
NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.

A = [9, 5, 4, 8]인 경우
NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] NGE = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        /*
        순차
        스텍 push
        스텍에 값v 있으면
            반복 (비어있지 않고 A[v] < A[i]인 동안)
                NGE[v]에 A[i] 삽입
            i push 후 다음 인덱스
        i 반복 종료시 전부 꺼내며 NGE[?]에 -1 삽입
         */
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                NGE[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            NGE[stack.pop()] = -1;
        }

        for (int i : NGE) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
