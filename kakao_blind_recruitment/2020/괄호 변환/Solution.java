class Solution {
	public boolean isCorrect(String s) {
		int cnt_l = 0;
		int cnt_r = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') cnt_l += 1;
			else cnt_r += 1;
			
			if(cnt_l < cnt_r) return false;
		}
		return true;
	}
	
	public String solution(String p) {			
		// 1. 빈 문자열인 경우 빈 문자열 반환
		if(p.equals("")) return p;
		
		// 2. w를 균형잡힌 괄호 문자열 u, v로 분리
		int cnt_l = 0; // '(' 개수
		int cnt_r = 0; // ')' 개수
		String u = "";
		String v = "";
		
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '(') cnt_l += 1;
			else cnt_r += 1;
			
			// u, v로 분리
			if(cnt_l == cnt_r) {
				u = p.substring(0, i + 1);
				v = p.substring(i + 1, p.length());
				break;
			}
		}
		
		String answer = "";
		
		// 3. u가 올바른 괄호 문자열인지 확인
		if(isCorrect(u)) {
			answer = u + solution(v);
		} else {
			answer += "(";
			answer += solution(v);
			answer += ")";
			
			// u의 첫 번째, 마지막 문자 제거
			u = u.substring(1, u.length() - 1);
			// 괄호 뒤집기
			String reverse = "";
			for(int i = 0; i < u.length(); i++) {
				if(u.charAt(i) == '(') reverse += ")";
				else reverse += "(";
			}
			answer += reverse;
		}
		
		return answer;
	}
}