import java.util.*;

class Solution {

    public int[] solution(int[] answers) {
        int[] arr_1 = {1, 2, 3, 4, 5};
        int[] arr_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt_1 = 0, cnt_2 = 0, cnt_3 = 0;
        
        // 첫 번째 문제의 답 확인     
        if(arr_1[0] == answers[0]) cnt_1 += 1;
        if(arr_2[0] == answers[0]) cnt_2 += 1;
        if(arr_3[0] == answers[0]) cnt_3 += 1;
        
        // 두 번째 문제부터 답 확인
        for(int i = 1; i < answers.length; i++) {
        	// 각 수포자의 답 확인
        	if(arr_1[i%5] == answers[i]) cnt_1 += 1;
        	if(arr_2[i%8] == answers[i]) cnt_2 += 1;
        	if(arr_3[i%10] == answers[i]) cnt_3 += 1;
        }
        
        // 가장 많이 맞힌 수포자의 문제의 수 구하기
        int max_cnt = Math.max(Math.max(cnt_1, cnt_2), cnt_3);
        
        // 가장 많은 문제를 맞힌 수포자 구하기
        List<Integer> list = new ArrayList<>();
        if(max_cnt == cnt_1) list.add(1);
        if(max_cnt == cnt_2) list.add(2);
        if(max_cnt == cnt_3) list.add(3);
        
//        Collections.sort(list); // list에 담을 때 오름차순으로 담았으므로 정렬할 필요 없음
        // 배열에 담기
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}