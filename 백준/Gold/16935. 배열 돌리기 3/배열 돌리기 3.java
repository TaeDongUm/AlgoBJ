import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] result;
	static int[][] arr;
	static int calculation;
	static int N,M,R;

	public static void main(String[] args) throws Exception{
		// 시간 초과
		// 입력값 선언, 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		// StringTokenizer를 이용하여 각각의 값을 받음.
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// 입력값을 받을 배열 선언
		arr= new int[N][M];
		// 연산 수행한 뒤 저장할 배열 선언
		result = new int[N][M];
		
		// for문을 통해 배열 입력값 받음
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 6가지 연산 중에 어떤 연산을 할지 
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
//			int r = R;
			calculation = Integer.parseInt(st.nextToken());
			if(calculation==1) {
				// while문으로 연산 횟수만큼 배열을 연산 수행 
//				while(r>0) {
					N = arr.length;
					M = arr[0].length;
					// 기존 배열을 x축으로 뒤집어야 하므로, i=N-1로 시작하며 i--를 함
					for(int i=N-1;i>=0;i--) {
						for(int j=0;j<M;j++) {
							result[N-1-i][j] = arr[i][j];
						}
					}
					// 이중 for문 한번 돌렸으니 연산 횟수 1 감소
//					r--;
//				}
				arr = new int[result.length][result[0].length];
				for(int i =0;i<result.length;i++) {
					arr[i] = result[i].clone();
				}
			}else if(calculation==2) { // y축 대칭이므로, j를 for문으로 먼저 돌림
//				while(r>0) {
					N = arr.length;
					M = arr[0].length;
					for(int j=M-1;j>=0;j--) {
						for(int i=0;i<N;i++) {
							// arr의 끝 column을 result의 첫번째 column으로 넣기 위해서
							result[i][M-1-j] = arr[i][j];
						}
					}
//					r--;
//				}
				arr = new int[result.length][result[0].length];
				for(int i =0;i<result.length;i++) {
					arr[i] = result[i].clone();
				}
			}else if(calculation==3) {// 90도 회전
//				while(r>0) {
					N = arr.length;
					M = arr[0].length;
					// N,M값을 회전할 떄마다 바꿔야 하기 떄문에, result[0].length, result.length를 이용
					result = new int[M][N];
					// 기존의 arr값을 시계방향 90도 회전
					for(int i =0;i<result[0].length;i++) {
						for(int j=0;j<result.length;j++) {
							result[j][result[0].length-1-i] = arr[i][j];
						}
					}
//					r--;
//				}
				arr = new int[result.length][result[0].length];
				for(int i =0;i<result.length;i++) {
					arr[i] = result[i].clone();
				}
			}else if(calculation==4) {
//				while(r>0) {
					N = arr.length;
					M = arr[0].length;
					// N,M값을 회전할 떄마다 바꿔야 하기 떄문에, result[0].length, result.length를 이용
					result = new int[M][N];
					// 기존의 arr값을 왼쪽 90도 회전
					for(int i =0;i<result[0].length;i++) {
						for(int j=0;j<result.length;j++) {
							result[result.length-1-j][i] = arr[i][j];
						}
					}
//					r--;
//				}
				arr = new int[result.length][result[0].length];
				for(int i =0;i<result.length;i++) {
					arr[i] = result[i].clone();
				}
			}else if(calculation==5) {
//				while(r>0) {
					N = arr.length;
					M = arr[0].length;
					result = new int[N][M];
					// 1번에서 2번으로
					for(int i =0;i<N/2;i++) {
						for(int j=0;j<M/2;j++) {
							result[i][j+M/2] = arr[i][j];
						}
					}
					// 2번에서 3번으로
					for(int i =0;i<N/2;i++) {
						for(int j=M/2;j<M;j++) {
							result[i+N/2][j] = arr[i][j];
						}
					}
					// 3번에서 4번으로
					for(int i =N/2;i<N;i++) {
						for(int j=M/2;j<M;j++) {
							result[i][j-M/2] = arr[i][j];
						}
					}
					// 4번에서 1번으로
					for(int i =N/2;i<N;i++) {
						for(int j=0;j<M/2;j++) {
							result[i-N/2][j] = arr[i][j];
						}
					}
//					r--;
//				}
				arr = new int[result.length][result[0].length];
				for(int i =0;i<result.length;i++) {
					arr[i] = result[i].clone();
				}
			}else if(calculation==6) {
				
//				while(r>0) {
					N = arr.length;
					M = arr[0].length;
					result = new int[N][M];
					// 1번에서 4번으로
					for(int i =0;i<N/2;i++) {
						for(int j=0;j<M/2;j++) {
							result[i+N/2][j] = arr[i][j];
						}
					}
					// 4번에서 3번으로
					for(int i =N/2;i<N;i++) {
						for(int j=0;j<M/2;j++) {
							result[i][j+M/2] = arr[i][j];
						}
					}
					// 3번에서 2번으로
					for(int i =N/2;i<N;i++) {
						for(int j=M/2;j<M;j++) {
							result[i-N/2][j] = arr[i][j];
						}
					}
					// 2번에서 1번으로
					for(int i =0;i<N/2;i++) {
						for(int j=M/2;j<M;j++) {
							result[i][j-M/2] = arr[i][j];
						}
					}
//					r--;
//				}
				arr = new int[result.length][result[0].length];
				for(int i =0;i<result.length;i++) {
					arr[i] = result[i].clone();
				}
			}
		
		}
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
//				System.out.print(arr[i][j]+" ");
				bw.write(arr[i][j]+" ");
			}
//			System.out.println();
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

}