import java.io.*;
import java.util.*;

/*
DSLR
0~9,999 십진수 저장

D: n을 두배로 바꾼다 (9999 보다 크면 10000으로 나눈 나머지)
-> 2n mod 10000

S: n-1 (0이라면 9999저장)
-> n-1 (if 0  9999)

L: n의 각 자릿수 왼편으로 회전시켜 그 결과 레지스터에 저장 위치(2341)
-> {(n%1000)*10} + n/1000

R: n의 각 자릿수 오른편으로 회전시켜 그 결과 레지스터에 저장 위치(4123)
-> {(n%10)*1000} + n/10

각 함수 생성하고 bfs 돌리기
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            String[] inputs = br.readLine().split(" ");
            sb.append(bfs(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]))).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    static class Node {
        int value;
        String path;

        Node(int value, String path) {
            this.value = value;
            this.path = path;
        }
    }

    static String bfs(int start, int target) {
        boolean[] v = new boolean[10000];
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(start,""));
        v[start] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int n = curr.value;
            String cPath = curr.path;

            if(n == target) return cPath;
            
             int d = D(n);
            if (!v[d]) {
                v[d] = true;
                q.offer(new Node(d, cPath + "D"));
            }

            int s = S(n);
            if (!v[s]) {
                v[s] = true;
                q.offer(new Node(s, cPath + "S"));
            }

            int l = L(n);
            if (!v[l]) {
                v[l] = true;
                q.offer(new Node(l, cPath + "L"));
            }

            int r = R(n);
            if (!v[r]) {
                v[r] = true;
                q.offer(new Node(r, cPath + "R"));
            }
        }

        return "";
    }

    static int D (int n) {
        return (2*n)%10000;
    }
    
    static int S (int n) {
        if (n==0) return 9999;
        else return n-1;
    }

    static int L (int n) {
        return ((n%1000)*10) + n/1000;
    }

    static int R (int n) {
        return ((n%10)*1000) + n/10;
    }
}