import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] board;
	static int[][][] visited;
	static int[] dx = {0,0,1,-1,0,0};
	static int[] dy = {1,-1,0,0,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static int preTomato, M, N, H, days;
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[N][M][H];
		visited = new int[N][M][H];
		
		Queue<int[]> q = new LinkedList<>();
		
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp ==0) preTomato++;
					if(tmp ==1) {
						visited[i][j][k] =1;
						q.add(new int[] {i,j,k});
					}
					board[i][j][k] = tmp;
				}
			}
		}
		bfs(board, visited, q);
		if(preTomato ==0) System.out.println(days-1);
		if(preTomato !=0) System.out.println(-1);
	}
	
	public static void bfs(int[][][] board, int [][][] visited, Queue<int[]> q) {
		if(preTomato ==0) {
			days =1;
			return;
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int z = cur[2];
			
			for(int i=0;i<6;i++) {
				int nx = x+ dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				
				if(nx>=0 && nx<N && ny >=0 && ny<M && nz>=0 && nz<H) {
					if(board[nx][ny][nz]==0 && visited[nx][ny][nz] !=1) {
						board[nx][ny][nz] = board[x][y][z] +1;
						visited[nx][ny][nz] =1;
						preTomato--;
						q.add(new int[] {nx, ny, nz});
						days = Math.max(days, board[nx][ny][nz]);
					}
				}
			}
		}
	}

}
