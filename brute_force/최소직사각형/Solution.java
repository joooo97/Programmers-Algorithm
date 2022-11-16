class Solution {
	
	public int solution(int[][] sizes) {	
    	int answer = 0;
    	int max_w = 0;
    	int max_h = 0;
    	
    	// 명함의 두 변중 긴 쪽을 가로로 지정, 짧은 쪽을 세로로 지정
    	for(int i = 0; i < sizes.length; i++) {
    		int w = Math.max(sizes[i][0], sizes[i][1]);
    		int h = Math.min(sizes[i][0], sizes[i][1]);
    		
    		// 지갑에 모든 명함이 들어가기 위해서는 가장 큰 가로 길이와 가장 큰 세로 길이가 되어야 함
    		max_w = Math.max(max_w, w);
    		max_h = Math.max(max_h, h);
    	}
    	
    	answer = max_w * max_h;
        return answer;
    }

}