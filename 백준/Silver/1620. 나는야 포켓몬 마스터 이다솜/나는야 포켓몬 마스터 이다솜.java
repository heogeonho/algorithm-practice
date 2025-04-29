import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> nameMap = new HashMap<>(); // 이름이 key
        HashMap<Integer, String> numMap = new HashMap<>(); // 숫자가 key
        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(name, i);
            numMap.put(i, name);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if(Character.isDigit(input.charAt(0))) {
                sb.append(numMap.get(Integer.parseInt(input))).append("\n");
            } else {
                sb.append(nameMap.get(input)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}