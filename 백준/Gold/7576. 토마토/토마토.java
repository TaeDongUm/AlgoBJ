import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int[][] visited;
	static int days, M, N;
	static int preTomato;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new int[N][M];
		
		Queue<int[]> q = new LinkedList<>();
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp == 0) preTomato++;
				if(tmp == 1) {
					q.add(new int[] {i,j});
					visited[i][j] =1;
				}
				board[i][j] = tmp;
			}
		}
		bfs(board, visited, q);
		if(preTomato !=0) System.out.println(-1);
		if(preTomato ==0) System.out.println(days);
		
		
	}
	public static void bfs(int[][] board, int[][] visited, Queue<int[]> q) {
		if(preTomato ==0) {
			days=0;
			return;
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(board[nx][ny]==0 && visited[nx][ny] !=1) {
						preTomato--;
						board[nx][ny] = board[x][y] +1;
						days = Math.max(days, board[nx][ny]-1);
						visited[nx][ny] = 1;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}

}
