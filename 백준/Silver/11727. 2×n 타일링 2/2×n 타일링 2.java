import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp =new int[1001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
        int answer = tile(N) % 10_0007;
		System.out.println(answer);
	}
	
	public static int tile(int N) {
		if(N<3) {
			return dp[N];
		}else{
			if(dp[N]==0) {
				dp[N] = (tile(N-1) + tile(N-2)*2)%10_007;
			}
		}
		return dp[N];
	}

}
