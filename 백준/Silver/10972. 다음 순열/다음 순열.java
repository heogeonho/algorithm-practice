import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
    N의 크기를 확인하지 않고 perm 전체를 구하는 로직을 활용해서 시간초과가 발생한 문제

    new idea로 사전순 정렬임을 활용하는 로직 채택
    주어진 입력이 1, 2, 3 이라면 주어진 숫자들을 활용해서 다음의 가장 작은 숫자를 찾는게 목적
    뒤에서 부터 탐색하여 숫자 비교 후 자리 교체를 하면 될 것이라고 판단
     */

    static int N;
    static int[] numbers;

    public static boolean nextPermutation() {
        // 뒤에서부터 탐색하여 증가하는 지점 찾기 (작은 단위에서 숫자 처리 위해)
        // 증가하는 지점을 찾는 이유는 내림차순인 부분은 어짜피 최대값이 될 것
        int i = N - 1;
        while (i > 0 && numbers[i - 1] >= numbers[i]) {
            i--;
        }

        // 마지막 순열이면 false
        if (i == 0) return false;

        // i-1 값보다 큰 값을 뒤에서부터 찾아 교환
        int j = N - 1;
        while (numbers[i - 1] >= numbers[j]) {
            j--;
        }

        swap(i - 1, j);

        // i 위치부터 끝까지 오름차순 정렬 (그 다음 가장 작은 수를 위해)
        int k = N - 1;
        while (i < k) {
            swap(i++, k--);
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 다음 순열 찾기
        if (nextPermutation()) {
            for (int num : numbers) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println(-1);
        }

        br.close();
    }
}
