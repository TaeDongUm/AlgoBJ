import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static List<Integer>[] bigList; // 1차원은 배열, 2차원은 리스트를 선언해서 값을 add 할 수 있게끔 했음
	static boolean[] visited; // 해당 정점을 방문했는지 표시하기 위해
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader로 입력 받기
		StringTokenizer st; // 공백 단위로 입력값 받기
		st = new StringTokenizer(br.readLine()); // StringTokenizer 객체 생성
		int N = Integer.parseInt(st.nextToken()); // 전체 사람의 수
		int M = Integer.parseInt(st.nextToken());	// 사람 관계 수
		
		bigList = new ArrayList[N]; // bigList 선언
		visited = new boolean[N];	// visited 선언
		cnt =0;	// 초기화
		for(int i=0;i<N;i++) { // 1차원은 배열이므로, 각 배열에 리스트 선언
			bigList[i] = new ArrayList<Integer>();
		}
		for(int i =0;i<M;i++) { // 사람 관계를 for문으로 돌면서 bigList에 담기
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bigList[a].add(b); // 서로 친구이므로 a,b 바꿔서 넣어주기
			bigList[b].add(a);
		}
		for(int i =0;i<N;i++) {
			if(cnt ==0) { // dfs에서 return 값이 0이라면 다음 dfs를 돌린다.
				dfs(i,1);
			}
		}
		System.out.println(cnt);
	}
	private static void dfs(int start, int depth) { // 시작점과 깊이를 넣어줌
		if(depth == 5) { // 서로 알고 있는 사람 관계가 5이면 return
			cnt = 1;
			return;
		}
		
		visited[start] = true; // 시작점을 true로 넣어줌
		for(int i : bigList[start]) { // start가 알고 있는 사람들을 하나하나씩 살펴보기
			int next = i;	// 다음 사람관계 파악하기 위해서 next에 i 넣어주기
			if(!visited[next]) { // 그 다음 사람이 방문처리 안했으면 다음 dfs 돌리기
				dfs(next, depth+1);
			}
		}
		visited[start] = false; // 만약 값이 안나오면 해당 사람 방문처리 안했다고 false 넣어주기
	}
	
}