import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
- 원형 구조에 대해 코드 수준에서 어떻게 처리할지 고민이 많았던 문제
- 부분합에 대한 개념이 부족했음 그래서 전체적 해법이 떠오르지 않았던 문제
 */
public class Main {
    static int S, m, n;
    static int[] pizzaA, pizzaB;
    static List<Integer> prefixSumA = new ArrayList<>();
    static List<Integer> prefixSumB = new ArrayList<>();
    static Map<Integer, Integer> countB = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        pizzaA = new int[m];
        pizzaB = new int[n];

        for (int i = 0; i < m; i++) pizzaA[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) pizzaB[i] = Integer.parseInt(br.readLine());

        getPrefixSum(pizzaA, prefixSumA, m);
        getPrefixSum(pizzaB, prefixSumB, n);

        // 추가로 해시맵 쓰는 좋은 아이디어도 결국 떠올리지 못했다
        // 내가 했으면 for문 돌려서 노가다 했을 것이다.
        for (int num : prefixSumB) {
            countB.put(num, countB.getOrDefault(num, 0) + 1);
        }

        // A에서 선택한 값과 B에서 보완하는 값으로 S를 만드는 경우의 수 찾기
        int answer = 0;
        for (int a : prefixSumA) {
            if (a == S) {
                answer++;
            }
            if (countB.containsKey(S - a)) {
                answer += countB.get(S - a);
            }
        }

        for (int b : prefixSumB) {
            if (b == S) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 원형 배열의 부분합 구하는 방식 (반복문의 size 조절에서 생각할 부분이 많았음)
    // 아이디어를 매우 생각해내기 어려웠던 문제
    static void getPrefixSum(int[] pizza, List<Integer> sumList, int size) {
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = 0; j < size - 1; j++) {
                sum += pizza[(i + j) % size];
                sumList.add(sum);
            }
        }
        sumList.add(Arrays.stream(pizza).sum());
    }
}