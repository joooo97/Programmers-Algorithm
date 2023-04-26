// - 오답, 다른 풀이 참고

import java.util.*;

class Solution {
    public List<String> routeList = new ArrayList<>();
    public boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        // 모든 가능한 경로 찾기
        dfs("ICN", "ICN", 0, tickets);
        
        // 순서가 앞서는 경로를 찾기 위해 정렬
        Collections.sort(routeList);
        String[] answer = routeList.get(0).split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, int cnt, String[][] tickets) {
        if(cnt == tickets.length) {
            routeList.add(route);
            return;
        }
        
        for(int i = 0; i < tickets.length; i++) {
            if(start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], cnt+1, tickets);
                visited[i] = false;
            }
        }
    }
}