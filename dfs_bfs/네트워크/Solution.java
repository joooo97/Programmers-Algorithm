class Solution {
    public boolean[] visited;
	
	public void dfs(int x, int[][] computers) {
		visited[x] = true;

		for(int y = 0; y < computers.length; y++) {
			if(computers[x][y] == 1 && !visited[y]) {
				dfs(y, computers);
			}
		}
	}
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
        	if(!visited[i]) {
        		dfs(i, computers);
        		answer += 1;
        	}
        }
        
        return answer;
    }
}