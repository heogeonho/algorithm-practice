import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st=new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        List<Integer> lis = new ArrayList<>();

        // 전체 순회 하면서 각각에 숫자에 대해 부분수열 가능 여부 조회
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int position =  binarySearch(lis, num); // 이분탐색으로 적절한 자리 탐색

            // 메인 idea를 구현한 부분
            // 적절한 위치가 맨 끝자리라면 값을 추가
            // 아니면 해당 위치의 값 교체
            if (position == lis.size()) {
                lis.add(num);
            } else {
                lis.set(position, num);
            }

        }
        System.out.println(lis.size());
    }

    // 이분 탐색 메서드 (target이 들어갈 위치를 찾음)
    // 크기 비교를 통해 위치 처리
    static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}