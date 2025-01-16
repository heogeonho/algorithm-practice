import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt();
        int N = sc.nextInt();
        
        List<Integer> perfectSquares = new ArrayList<>();
        
        for (int i = (int) Math.sqrt(M); i <= Math.sqrt(N); i++) {
            int square = i * i;
            if (square >= M && square <= N) {
                perfectSquares.add(square);
            }
        }
        
        if (perfectSquares.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            for (int square : perfectSquares) {
                sum += square;
                if (square < min) min = square;
                if (square > max) max = square;
            }
            
            System.out.println(sum);
            System.out.println(min);
        }
        
        sc.close();
    }
}