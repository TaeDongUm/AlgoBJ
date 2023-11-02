import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static final int value = 1_000_000_003;
	static int dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++){
			
			//초기화 작업
			dp[i][1] = i; // i개 중에서 1개를 선택하는 방법은 i개
			
			
			dp[i][0] = 1; // 0개를 선택한 경우는 1로 초기화
		}
		
		// i가 3미만인 경우는 계산할 필요가 없음
		for(int i = 3; i <= N; i++){
			
			// n개의 수 중 n/2개 보다 더 많이 고르는 방법은 0개
			for(int j = 2; j <= (i + 1) / 2; j++){
				// i번째 색을 선택하지 않은 경우 + i번째 색을 선택한 경우
				dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % value;
			}
		}
		// n번째 색을 선택한 경우 + n번째 색을 선택하지 않은 경우
		System.out.println((dp[N - 3][K - 1] + dp[N - 1][K]) % value );
		
	}

}
