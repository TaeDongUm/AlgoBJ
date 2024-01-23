import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static String[][] board;
	static char[][] visited;
	static int Jcount, minMove=1;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean check = false;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new String[R][C];
		visited = new char[R][C];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			String line = br.readLine();
			for(int j=0;j<C;j++) {
				char input = line.charAt(j);
				if(input =='J') {
                    Jcount++;
					q.add(new int[] {i,j,1});
					visited[i][j] = 'J';
					board[i][j] = "1";
				}else if(input == '#') {
					visited[i][j] = '#';
					board[i][j] ="#";
				}else {
					board[i][j]=Character.toString(input);
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(board[i][j].equals("F")) {
					q.add(new int[] {i,j,0});
					visited[i][j] = 'F';
					board[i][j] = "F";
				}
			}
		}
		bfs(board, visited, q);
		if(check == false) System.out.println("IMPOSSIBLE");
		if(check == true) System.out.println(minMove);
	}
	public static void bfs(String[][] board, char[][] visited, Queue<int[]> q) {
		while(!q.isEmpty()) {
            if(Jcount ==0) return;
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int JorF = cur[2];
			
			if(JorF == 1) { // J일 경우
				if(board[x][y].equals("F")) continue;
				if(x==0 || x ==R-1 || y ==0|| y ==C-1) {
					minMove = Integer.parseInt(board[x][y]);
					check = true;
					return;
				}
				
				for(int i=0;i<4;i++) {
					int nx = x+ dx[i];
					int ny = y+ dy[i];
					
					if(nx>=0 && nx<R && ny >=0 && ny<C) {
						if(board[nx][ny].equals(".") && (visited[nx][ny] !='J' && visited[nx][ny] != 'F' && visited[nx][ny] !='#')) {
							board[nx][ny] = (Integer.parseInt(board[x][y]) +1)+"";
							visited[nx][ny] = 'J';
							q.add(new int[] {nx,ny, 1});
						}
					}
				}
				
			}
			if(JorF == 0) { // F일 경우
				for(int i=0;i<4;i++) {
					int nx = x+ dx[i];
					int ny = y+ dy[i];
					
					if(nx>=0 && nx<R && ny >=0 && ny<C) {
						if(!board[nx][ny].equals("#") && (visited[nx][ny] != 'F' && visited[nx][ny] !='#')) {
							if(board[nx][ny].equals("J")) Jcount--;
                            board[nx][ny] ="F";
							visited[nx][ny] = 'F';
							q.add(new int[] {nx,ny, 0});
                            
						}
					}
				}
			}
		}
	}
}
