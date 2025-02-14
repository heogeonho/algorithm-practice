import java.util.ArrayDeque;

class Solution {
    static boolean[] isVisited;
    static int[] dist;

    static int solution(String begin, String target, String[] words) {
        if (!contains(words, target)) return 0;
        return bfs(begin, target, words);
    }

    public static boolean contains(String[] words, String target) {
        for (String word : words) {
            if (word.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPossibleNext(String from, String to) {
        int cnt = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public static int bfs(String begin, String target, String[] words) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        isVisited = new boolean[words.length];
        dist = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            if (isPossibleNext(begin, words[i])) {
                isVisited[i] = true;
                dist[i] = 1;
                if (target.equals(words[i])) {
                    return dist[i];
                }
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int i = 0; i < words.length; i++) {

                if (isVisited[i]) continue;
                if (isPossibleNext(words[idx], words[i])) {
                    isVisited[i] = true;
                    dist[i] = dist[idx] + 1;
                    q.offer(i);
                    if (target.equals(words[i])) {
                        return dist[i];
                    }
                }
            }
        }
        return 0;
    }
}