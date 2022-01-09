import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] arr_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int idx_1 = 0, idx_2 = 0, idx_3 = 0;
        int cnt_1 = 0, cnt_2 = 0, cnt_3 = 0;
        
        for(int i = 0; i < answers.length; i++) {
            // 1번 수포자 정답 확인
            if(answers[i] == arr_1[idx_1]) cnt_1 += 1;
            // 2번 수포자 정답 확인
            if(answers[i] == arr_2[idx_2]) cnt_2 += 1;
            // 3번 수포자 정답 확인
            if(answers[i] == arr_3[idx_3]) cnt_3 += 1;
            
            idx_1 += 1;
            idx_2 += 1;
            idx_3 += 1;
            
            if(idx_1 == 5) idx_1 = 0;
            if(idx_2 == 8) idx_2 = 0;
            if(idx_3 == 10) idx_3 = 0;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int max_cnt = Math.max(Math.max(cnt_1, cnt_2), cnt_3);
        
        if(max_cnt == cnt_1) list.add(1);
        if(max_cnt == cnt_2) list.add(2);
        if(max_cnt == cnt_3) list.add(3);
        
        int[] answer = new int[list.size()];
        int idx = 0;
        for(int i : list)
        	answer[idx++] = i;
        
        return answer;
    }
}