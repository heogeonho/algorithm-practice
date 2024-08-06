class Solution {  
    static boolean[] v;  
    static int cnt = 0;  
  
    public int solution(int k, int[][] dungeons) {  
        v = new boolean[dungeons.length];  
        dfs(0, k, dungeons);  
        return cnt;  
    }  
      
    private void dfs(int depth, int fatigue, int[][] dungeons){  
        for (int i = 0; i < dungeons.length; i++){  
            if (v[i] || dungeons[i][0] > fatigue) {  
                continue;  
            }  
            v[i] = true;  
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);  
            v[i] = false;  
        }  
        cnt = Math.max(cnt, depth);  
    }  
}