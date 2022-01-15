import java.util.*;

class Node {
	String str;
	int cnt;

	Node(String str, int cnt) {
		this.str = str;
		this.cnt = cnt;
	}
}

class Solution {
    public int solution(String begin, String target, String[] words) {
		boolean check = false;
		for(int i = 0; i < words.length; i++) {
			if(target.equals(words[i])) {
				check = true;
				break;
			}
		}
		
		// target으로 변환할 수 없는 경우
		if(!check) return 0;
		
        int answer = 0;
		int[] d = new int[words.length];
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(begin, 0));
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			String str = now.str;
			
			if(str.equals(target)) {
				answer = now.cnt;
				break;
			}
			
			// 변환할 수 있는 단어 찾기
			for(int i = 0; i < words.length; i++) {
				int cnt = 0; // 일치하지 않는 알파벳의 개수
				for(int j = 0; j < str.length(); j++) {
					if(str.charAt(j) != words[i].charAt(j)) cnt += 1;
				}
				
				if(cnt == 1 && d[i] == 0) {
					q.offer(new Node(words[i], now.cnt + 1));
					d[i] = now.cnt + 1;
				}
			}
		}
		
		return answer;
    }
}