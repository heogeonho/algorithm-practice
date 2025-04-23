import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        // 중복 제거를 위한 set
        Set<String> set = new HashSet<>();

        // 모든 부분 문자열 순회 및 set에 삽입
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                set.add(str.substring(i, j));
            }
        }
        
        // set의 사이즈가 원하는 결과
        System.out.println(set.size());
    }
}