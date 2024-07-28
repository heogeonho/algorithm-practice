import java.util.Arrays;

class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer =new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int commandRange=commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[commandRange];

            int k=0;
            for (int j = commands[i][0]; j <= commands[i][1]; j++) {
                temp[k++] = array[j - 1];
            }
            Arrays.sort(temp);
            answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}