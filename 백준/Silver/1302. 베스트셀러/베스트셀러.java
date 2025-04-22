import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // map 자료구조 정의 확실히 기억하기
        Map<String, Integer> bookSales = new HashMap<>();
        int max = -1;
        for(int i = 0; i < N; i++) {
            String bookName = br.readLine();
            
            // getOrDefault 활용 익히기
            bookSales.put(bookName, bookSales.getOrDefault(bookName, 0)+1);
            max = Math.max(max, bookSales.get(bookName));
        }
        List<String> bestSeller = new ArrayList<>();

        // entrySet 활용 익히기
        for (Map.Entry<String, Integer> entry : bookSales.entrySet()) {
            if (entry.getValue() == max) {
                bestSeller.add(entry.getKey());
            }
        }
        Collections.sort(bestSeller);
        System.out.println(bestSeller.get(0));
    }
}