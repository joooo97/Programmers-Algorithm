import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] seperate_arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]); // 배열 자르기
            Arrays.sort(seperate_arr); // 배열 정렬
            answer[i] = seperate_arr[commands[i][2]-1];
        }   
        return answer;
    }
}