import java.io.*;
import java.util.*;

// 우선순위 큐 (최소값을 계속해서 갱신해야 함, 즉 반복되는 정렬 수행)

// < 0이 입력된 경우 >
// 배열에 값 x -> 0 출력
// 배열에 값 o -> 가장 작은 값 출력

// < 자연수 입력된 경우 >
// 값 삽입

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N-- > 0) {
            String input = br.readLine();
            if(!input.equals("0")) {
                pq.offer(Integer.parseInt(input));
            } else {
                if (pq.size()==0) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}