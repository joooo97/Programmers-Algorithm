import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        
        // 필요한 작업 일수를 구하여 큐에 넣기
        for(int i = 0; i < progresses.length; i++) {
            // 필요한 작업 일수 구하기
            int need_day = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) need_day += 1;
            q.offer(need_day);
        }
        
        // 각 배포일의 기능 개수 구하기
        int cur_day = q.poll();
        int cnt = 1;
        List<Integer> cnt_list = new LinkedList<>();
        
        while(!q.isEmpty()) {
            // 같은 날에 배포 가능한 경우
            if(cur_day >= q.peek()) {
                cnt += 1;
                q.poll();
            } else { // 같은 날에 배포 불가능한 경우
                cnt_list.add(cnt);
                cnt = 1;
                cur_day = q.poll();
            }
        }
				// while문을 나가게되면 마지막 cnt는 리스트에 담기지 않으므로 넣어주기
        cnt_list.add(cnt);
        
        int[] answer = new int[cnt_list.size()];
        for(int i = 0; i < cnt_list.size(); i++) {
            answer[i] = cnt_list.get(i);
        }
        
        return answer;
    }
}