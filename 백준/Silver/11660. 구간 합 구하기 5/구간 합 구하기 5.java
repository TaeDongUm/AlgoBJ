import java.io.*;
import java.util.StringTokenizer;
public class Main {

	static int x1,x2,y1,y2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n=Integer.parseInt(st.nextToken()); // matrix의 전체 크기 입력 받기
		int m=Integer.parseInt(st.nextToken()); // 구간합 구하기 횟수
		
		// 누적합을 구하는 공식이 이전 행과 열 값을 더하고 뺴는 것이기 때문에 0번쨰 열과 행을 0으로 초기화시키면
		// arr에서 값이 처음 시작하는 행과 열의 값을 구할 수 있다.
		int[][] arr=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				// 그 자리의 누적합은 (해당 자리) + (행으로 바로 위쪽) + (열로 바로 왼쪽) - (왼쪽 상단 대각선)
				arr[i][j]+=arr[i-1][j]+arr[i][j-1]-arr[i-1][j-1]; 
			}
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			// 합을 구하고자 하는 범위 입력 받기
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			// 위에서 누적합을 이미 구했기 때문에 누적합 arr에서 
			// (x1-1, y2)까지의 누적합 + (x2, y1-1)까지의 누적합 - (x1-1, y1-1)까지의 누적합을 계산하면 범위에 해당하는
			// 누적합을 구할 수 있다.
			sb.append(arr[x2][y2]-arr[x1-1][y2]-arr[x2][y1-1]+arr[x1-1][y1-1]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}