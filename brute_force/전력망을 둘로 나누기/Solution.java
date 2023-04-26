// - 오답, 다른 풀이 참고

import java.util.*;

class Solution {
    public static int[][] graph;
    
    public int solution(int n, int[][] wires) {
        // 1. 송전탑 정보 입력
        graph = new int[n+1][n+1]; // 송전탑은 1번부터 시작하므로 n+1의 길이까지 생성
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            graph[a][b] = graph[b][a] = 1;
        }
                
        // 2. 전선을 끊고, 송전탑 개수의 차이 비교하기
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            
            // 전선 끊기
            graph[a][b] = graph[b][a] = 0;
            
            // bfs 사용하여 송전탑 개수의 차이 비교하기
            answer = Math.min(answer, bfs(n));
            
            // 전선 되돌리기
            graph[a][b] = graph[b][a] = 1;
            
        }
        
        return answer;
    }
    
    // 두 전선망의 송전탑 개수의 차이 반환
    public int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int cnt = 1; // 현재 전선망의 송전탑 개수
        
        q.offer(1);
        visited[1] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            
            for(int y = 1; y <= n; y++) {
                if(graph[x][y] == 1 && !visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                    cnt += 1;
                }
            }
        }
        
        // 두 전력망의 송전탑 개수 차이 구하기
        int other_cnt = n - cnt;
        
        return Math.abs(cnt - other_cnt);
    }
}