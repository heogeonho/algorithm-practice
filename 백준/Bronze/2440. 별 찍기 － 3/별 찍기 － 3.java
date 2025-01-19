import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();

        // 별 출력
        for (int i = n; i > 0; i--) { // i는 n에서 시작해서 1까지 감소
            for (int j = 0; j < i; j++) { // i만큼 별 출력
                System.out.print("*");
            }
            System.out.println(); // 줄 바꿈
        }
        
        scanner.close();
    }
}