import java.util.Scanner;

public class Solution{ 
	static int N,M, answer, bigcount, smallcount;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt(); //학생 수
			M = sc.nextInt(); //비교 횟수
			
			map = new int[N+1][N+1];
			answer = 0;
			
			for(int i=0; i<M; i++) { // 인접 행렬로 입력값 받기
				int from = sc.nextInt(); // 작은 값
				int to = sc.nextInt(); // 큰 값
				map[from][to] = 1; // 작은 값, 큰 값을 인덱스로 map에 1값을 넣기
			}
			
			for(int i=1; i<N+1; i++) {
				bigcount = 0; // 자신보다 큰 값 초기화
				smallcount = 0; // 자신보다 작은 값 초기화
				big(i, new boolean[N+1]);
				small(i, new boolean[N+1]);
				// 자기자신을 제외한 나머지 값만큼 존재해야 확실하게 자기자신의 순위를 알 수 있기 떄문
				if(bigcount + smallcount == N-1) 
					answer++;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	// 1~N번까지 다 돌면서 N보다 작은 값, 큰 값을 주어진 학생 비교로 세기
	
	static void big(int from, boolean[] visited) {
		visited[from] = true;
		for(int i=1; i<N+1; i++) {
			if(!visited[i] && map[from][i] == 1) {
				// i번 째에 대해 큰 값 다 세기
				big(i, visited);
				bigcount++;
			}
		}
	}
	static void small(int to, boolean[] visited) {
		visited[to] = true;
		for(int i=1; i<N+1; i++) {
			if(!visited[i] && map[i][to] == 1) {
				// i번째에 대해 작은 값 다 세기
				small(i, visited);
				smallcount++;
			}
		}
	}
}