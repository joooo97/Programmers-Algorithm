class Solution {
	public int answer = 0;
	public boolean[] visited;
	
	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		recur(k, dungeons, 0);
		
		return answer;
	}
	
	public void recur(int k, int[][] dungeons, int cnt) {
		for(int i = 0; i < dungeons.length; i++) {
			if(!visited[i] && dungeons[i][0] <= k) {
				visited[i] = true;
				recur(k - dungeons[i][1], dungeons, cnt + 1);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, cnt);
	}
}