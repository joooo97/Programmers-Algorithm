import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
		// target과 일치하는 단어의 인덱스
		int target_idx = -1;
		for(int i = 0; i < words.length; i++) {
			if(target.equals(words[i])) target_idx = i;
		}
		
		// target으로 변환할 수 없는 경우
		if(target_idx == -1) return 0;
		
		int[] d = new int[words.length];
		Queue<Integer> q = new LinkedList<>();
		q.offer(-1);
		
		while(!q.isEmpty()) {
			int now_idx = q.poll();
			int now_d = 0;
			String now_str = null;

			if(now_idx == -1) { // begin인 경우
				now_str = begin;
				now_d = 0;
			}
			else {
				now_str = words[now_idx];
				now_d = d[now_idx];
			}
			
			// 변환할 수 있는 단어 찾기
			for(int i = 0; i < words.length; i++) {
				int cnt = 0; // 일치하지 않는 알파벳의 개수
				for(int j = 0; j < now_str.length(); j++) {
					if(now_str.charAt(j) != words[i].charAt(j)) cnt += 1;
				}
				
				if(cnt == 1 && d[i] == 0) {
					q.offer(i);
					d[i] = now_d + 1;
				}
			}
		}
		
		return d[target_idx];
    }
}