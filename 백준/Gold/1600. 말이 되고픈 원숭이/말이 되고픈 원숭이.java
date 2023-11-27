import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int k,w,h;
	static int[][] map;
	static int[] dx= {1,-1,0,0}, dy= {0,0,1,-1};
	static int[] hx = {1,2,2,1,-1,-2,-2,-1};
	static int[] hy = {2,1,-1,-2,-2,-1,1,2};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
	
		map = new int[h][w];
		
		for(int i=0; i<h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs(0,0));
	}
	
	static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] check = new boolean[h][w][k+1];
		
		check[x][y][0] = true;
		q.add(new int[] {x,y,0,0});
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0], py = pos[1];
			int knight_move = pos[2], move = pos[3];
            
			// 도착지점 리턴
			if(px==h-1 && py==w-1) {
				 return move;
			}
            
			// 원숭이 4가지 방향 탐색
			for(int i=0; i<4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx<0 || nx>h-1 || ny<0 || ny>w-1) continue;
				if(check[nx][ny][knight_move])  continue;
				
				if(map[nx][ny] != 1) {
					check[nx][ny][knight_move] = true;
					q.add(new int[] {nx,ny,knight_move, move+1});
				}
			}

			// 말 이동 횟수 남아있으면 말 8가지 방향 탐색 
			if(knight_move<k){
				for(int i=0; i<8; i++) {
					int nx = px + hx[i];
					int ny = py + hy[i];
					
					if(nx<0 || nx>h-1 || ny<0 || ny>w-1) continue;
					if(check[nx][ny][knight_move+1])  continue;
					
					if(map[nx][ny] != 1) {
						check[nx][ny][knight_move+1] = true;
						q.add(new int[] {nx,ny,knight_move+1, move+1});
					}
				}
			}
		}
		return -1;
	}
}