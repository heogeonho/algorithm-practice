import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        
        // num = num >> 1;
        // System.out.println(num); // 32
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 64;
        pq.offer(64);
        if (X == 64) System.out.println(1);
        while (total != X) {
            int temp = pq.poll();
            temp = temp >> 1;
            if (total - temp >= X) {
                pq.offer(temp);
                total -= temp;       
                if (total==X) {
                    System.out.println(pq.size());
                    break;
                }
            } else {
                pq.offer(temp);
                pq.offer(temp);
            }
        }
    }
}

/*
 * 64                           64 스타트
 * 
 * 32   32      분리             64 첫 값 꺼내어 분리 / 분리 값 - 시 X 보다 큼 
 * 32           제거             32 하나만 추가 (값 업데이트)
 * 
 * 16   16      분리             32 첫 값 꺼내어 분리 / 분리 값 - 시 X 보다 작음 / 둘다 추가
 * 
 * 16   8   8   분리             32 첫 값 꺼내어 분리 / 분리 값 - 시 X 보다 큼 
 * 16   8       제거             24 하나만 추가 (값 업데이트)
 * 
 * 16   4   4   분리             24 첫 값 꺼내어 분리 / 분리 값 - 시 X 보다 작음 / 둘다 추가
 * 
 * 16   4   2   2       분리     24 첫 값 꺼내어 분리 / 분리 값 - 시 X 보다 작음 / 둘다 추가
 * 
 * 16   4   2   1   1   분리     24 첫 값 꺼내어 분리 / 분리 값 - 시 X 보다 큼
 * 16   4   2   1       제거     23 하나만 추가 (값 업데이트)
 */