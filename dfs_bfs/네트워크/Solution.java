class Solution {
    public void dfs(int[][] computers, boolean[] visited, int x) {
        visited[x] = true;
        
        for(int y = 0; y < computers.length; y++) {
            if(computers[x][y] == 1 && !visited[y])
                dfs(computers, visited, y);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer += 1;
            }
        }
        
        return answer;
    }
}