import java.util.Scanner;
class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[101][101];
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for(int j =b;j<b+10;j++) {
				for(int k =a;k<a+10;k++) {
					map[j][k] +=1;
				}
			}
		}
		int count =0;
		for(int i=0;i<=100;i++) {
			for(int j =0;j<=100;j++) {
				if(map[i][j] !=0) {
					count +=1;
				}
			}
		}
		System.out.println(count);
	}

}
