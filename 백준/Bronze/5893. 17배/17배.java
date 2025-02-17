import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binaryInput = br.readLine().trim(); // 입력 받기

        // 2진수를 BigInteger(10진수)로 변환
        BigInteger decimal = new BigInteger(binaryInput, 2);

        // 17배 연산
        BigInteger result = decimal.multiply(BigInteger.valueOf(17));

        // 결과를 2진수로 변환하여 출력
        System.out.println(result.toString(2));
    }
}