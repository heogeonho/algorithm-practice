import java.util.Arrays;

class Solution {
    
	static int answer;
     public static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public static int solution(int n, int[][] costs) {
       answer =0;

        // 1. 간선들을 비용에 따라 오름차순으로 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        System.out.println(Arrays.deepToString(costs));

        // 2. 부모 배열 초기화
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 3. 간선들을 순회하며 최소 비용으로 모든 섬을 연결
        for (int i = 0; i < costs.length; i++) {
            int start = findParent(parent, costs[i][0]);
            int end = findParent(parent, costs[i][1]);

            // 사이클이 발생하지 않으면 해당 간선을 선택
            if (start != end) {
                parent[end] = start;
                answer += costs[i][2];
            }
        }

        return answer;
    }
}