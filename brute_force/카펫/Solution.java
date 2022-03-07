class Solution {
	
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int cnt = brown + yellow; // 전체 격자 개수
        
        for(int w = 1; w <= cnt; w++) { // w: 가로 길이
        	int h = cnt / w; // 세로 길이
        	
        	// 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 길다.
        	if(cnt % w != 0 || w < h) continue;
        	
        	if(yellow == (w - 2) * (h - 2)) {
        		answer[0] = w;
        		answer[1] = h;
        		break;
        	}
        }
        return answer;
    }
}