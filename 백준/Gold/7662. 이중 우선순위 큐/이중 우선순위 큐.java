import java.io.*;
import java.util.*;

// TreeMap 활용하기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char command = input[0].charAt(0);
                int num = Integer.parseInt(input[1]);

                if (command == 'I') {
                    // 이미 존재하면 개수 증가
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int key = (num == 1) ? map.lastKey() : map.firstKey(); // 최대 최소값 선택
                    int count = map.get(key);

                    if (count == 1) map.remove(key); // 개수 1이면 제거
                    else map.put(key, count - 1);    // 아니면 개수만 감소
                }
            }

            // 출력 map이 비었으면 EMPTY 아니면 최대값 최소값
            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}