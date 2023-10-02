import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int a=0;a<T;a++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] B = new int[n+1][m+1];
			for (int i = 0; i <= n; i++) {
				for(int j=0, end=Math.min(i,m);j<=end;j++) {
					if(j==0 || i==j) B[i][j] = 1;
					else B[i][j] = B[i-1][j-1] + B[i-1][j];
				}
			}
			System.out.println(B[n][m]);
			
		}
	}
}
