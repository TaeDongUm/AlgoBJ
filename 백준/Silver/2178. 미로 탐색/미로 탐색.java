import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int[][] board, visited;
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		visited = new int[N][M];
		
		String input="";
		for(int i =0;i<N;i++) {
			input = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = input.charAt(j) - '0';
			}
		}
		
		bfs(board, visited, 0, 0);
		System.out.println(board[N-1][M-1]);
		
	}
	public static void bfs(int[][] board, int[][] visited, int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,b});
		visited[a][b] = 1;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && nx<N && ny >=0 && ny <M) {
					if(board[nx][ny] != 0 && visited[nx][ny] ==0) {
						visited[nx][ny] = 1;
						board[nx][ny] = board[x][y] +1;
						q.add(new int[] {nx, ny});
						
					}
				}
			}
		}
	}

}
