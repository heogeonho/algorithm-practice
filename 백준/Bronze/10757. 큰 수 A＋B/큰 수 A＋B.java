import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 두 개의 매우 큰 정수를 입력받습니다.
        String a = scanner.next();
        String b = scanner.next();
        
        // BigInteger 객체를 사용하여 문자열을 숫자로 변환합니다.
        BigInteger num1 = new BigInteger(a);
        BigInteger num2 = new BigInteger(b);
        
        // 두 수의 합을 계산합니다.
        BigInteger sum = num1.add(num2);
        
        // 결과를 출력합니다.
        System.out.println(sum);
        
        scanner.close();
    }
}