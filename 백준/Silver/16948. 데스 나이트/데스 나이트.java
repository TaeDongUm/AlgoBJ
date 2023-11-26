import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class knight{
	int r; // 열
	int c; // 행
	int cnt; // 이동 횟수
	knight(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main {
	static int N; 
	static int r1, c1; // 시작 위치
	static int r2, c2; // 도착해야하는 위치
	
	static int[][] board; // 체스판
	static boolean[][] check; //방문체크
	
	static int[] dr = {-2, -2, 0, 0, 2, 2}; 
	static int[] dc = {-1, 1, -2, 2,-1, 1}; 
	
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 체스판의 크기
		
		board = new int[N+1][N+1]; // 체스판
		check = new boolean[N+1][N+1]; // 방문체크
		
		r1 = sc.nextInt(); // 시작 열 위치
		c1 = sc.nextInt(); // 시작 행 위치
		r2 = sc.nextInt(); // 도착해야하는 열 위치
		c2 = sc.nextInt(); // 도착해야하는 행 위치
		
		BFS();
		
	}
	
	public static void BFS() {
		Queue<knight> que = new LinkedList<knight>();
		que.add(new knight(r1,c1,0));
		check[r1][c1] = true;
		
		while(!que.isEmpty()) {
			knight k = que.poll();
			
			//6방면 탐색
			for(int i=0;i<6;i++) {
				int nr = k.r + dr[i];
				int nc = k.c + dc[i];
				
				if(nr<0 || nc<0 || nr>N || nc>N || check[nr][nc]) continue;
				
				//탐색하면서 도착해야하는 열과 행의 위치가 됐으면 이동 횟수를 1 증가시켜 출력하고 종료
				if(nr==r2 && nc==c2) {
					System.out.println(k.cnt+1);
					System.exit(0);
				}
				
				//도착못했으면 방문 체크하고, 다시 큐에 넣어
				check[nr][nc] = true;
				que.add(new knight(nr,nc,k.cnt+1));
			}
		}
		
		//BFS 돌렸는데도 도착못했으면 종료
		System.out.println(-1);
		
	}
}