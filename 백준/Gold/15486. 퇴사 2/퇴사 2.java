import java.io.*;
import java.util.*;

public class Main {
	static int max = Integer.MIN_VALUE;
	static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];		// 상담일
        int[] P = new int[N+2];		// 비용
        
        // 해당 날짜까지 벌 수 있는 최대 비용
        int[] DP = new int[N+2];	// 마지막 날 상담일이 1일일 경우 그 다음날 비용을 받으므로, 인덱스 0을 안쓰므로 +2

        for(int i = 1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<N+1; i++){
            // 현재 날짜에서 얻을 수 있는 최대 수익
            max = Math.max(max, DP[i]);
            
            // 가능한 다음 상담 일자
            int next = i + T[i];
            
            // 상담을 기간 안에 끝낼 수 있다면 상담 진행
            if(next < N+2){
            	
            	// 얻을 수 있는 수익 중 최대 수익 저장
                DP[next] = Math.max(DP[next], max + P[i]);
                
                // 최대 수익인 정답 저장
                ans = Math.max(ans, DP[next]);
            }
        }
        System.out.println(ans);
    }
}