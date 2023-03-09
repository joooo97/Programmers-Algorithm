import java.util.*;

class Solution {
	
	public static int n, m;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][] d;
	
	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;
		d = new int[n][m];
		
		bfs(maps);
		
		int answer = (d[n-1][m-1] == 0 ? -1 : d[n-1][m-1]);
		return answer;
	}
	
	public void bfs(int[][] maps) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0));
		d[0][0] = 1;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				
				if(maps[nx][ny] == 1 && d[nx][ny] == 0) {
					q.offer(new Pos(nx, ny));
					d[nx][ny] = d[p.x][p.y] + 1;
				}
			}
		}
	}
}

class Pos {
	int x;
	int y;
	
	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}