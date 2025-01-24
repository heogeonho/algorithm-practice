import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int N = sc.nextInt(); // 도시 개수
        int M = sc.nextInt(); // 도로 개수
        int K = sc.nextInt(); // 거리 정보
        int X = sc.nextInt(); // 시작 도시

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
        }

        int[] distances = new int[N + 1];
        Arrays.fill(distances, -1);
        distances[X] = 0; // 시작 도시의 거리는 0

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        // BFS
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (distances[next] == -1) { // 아직 방문하지 않은 도시만
                    distances[next] = distances[current] + 1;
                    queue.add(next);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distances[i] == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result); // 오름차순 정렬
            for (int city : result) {
                System.out.println(city);
            }
        }

        sc.close();
    }
}