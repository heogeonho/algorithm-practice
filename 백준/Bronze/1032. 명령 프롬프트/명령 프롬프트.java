import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] files = new String[n];

        // 파일 이름 입력 받기
        for (int i = 0; i < n; i++) {
            files[i] = br.readLine();
        }

        // 첫 번째 파일 이름을 기준으로 초기 패턴 설정
        char[] pattern = files[0].toCharArray();

        // 다른 파일 이름들과 비교하여 공통 패턴 도출
        for (int i = 1; i < n; i++) {
            char[] currentFile = files[i].toCharArray();
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] != currentFile[j]) {
                    pattern[j] = '?'; // 공통되지 않는 부분은 '?'로 대체
                }
            }
        }

        // 결과 출력
        System.out.println(new String(pattern));
    }
}