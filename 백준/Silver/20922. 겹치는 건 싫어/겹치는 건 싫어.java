        import java.io.*;
        import java.util.*;

        class Main {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());

                int N = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());
                int[] a = new int[N];

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

                // 빈도 카운팅 배열 freq int[100001]
                int[] freq = new int[100001];

                // l=0 r=k-1 시작
                int l = 0;
                int max = 0;

                // freq a[r] = k된 순간 l값 업데이트 i 나올 때까지
                for (int r = 0; r < N; r++) {
                    int f = freq[a[r]];
                    freq[a[r]]=f+1;

                    while (freq[a[r]] > K) {
                        freq[a[l]]--;
                        l++;
                    }                    
                    
                    max = Integer.max(max, r-l+1);
                }
                System.out.println(max);
            }
        }