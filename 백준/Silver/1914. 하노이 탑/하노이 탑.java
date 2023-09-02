import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger big = new BigInteger("1"); 
		int N = Integer.parseInt(br.readLine());
 
		if(N<=20) {
            sb.append((int) (Math.pow(2, N) - 1)).append('\n');
            Hanoi(N, 1, 2, 3);
			System.out.println(sb);
		}else {
			for(int i=0;i<N;i++) {
				big = big.multiply(new BigInteger("2"));
			}
			big = big.subtract(new BigInteger("1"));
			System.out.println(big);
		}
	}
	public static void Hanoi(int N, int start, int mid, int to) {
		// 맨 마지막 원판만 남는다면
		if (N == 1) {
			sb.append(start).append(" ").append(to).append("\n");
			return;
		}
 		// 1기둥 -> 3기둥으로 옮기는 작업
        
		// N-1개를 1 기둥 에서 2 기둥으로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
		Hanoi(N - 1, start, to, mid);
    
		// 1개를 1 기둥에서 3 기둥으로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
        // 원판 하나를 옮기는 작업이므로 재귀를 돌릴 필요없다.
		sb.append(start).append(" ").append(to).append("\n");
    
		// N-1개를 2 기둥에서 3기둥으로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
		Hanoi(N - 1, mid, start, to);
	}

}