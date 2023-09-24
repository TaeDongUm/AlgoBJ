import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int prevMax=0;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int N = sc.nextInt();
		for(int i =0;i<N;i++) {
			int a = sc.nextInt();
			if(prevMax <= a) {
				for(int j=prevMax+1;j<=a;j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				int b = stack.pop();
				prevMax = a;
				if(a != b) {
					System.out.println("NO");
					flag = true;
					break;
				}else {
					sb.append("-").append("\n");
				}
			}else { // 현재 값이 더 작다면 (이전에 쌓은 stack 값이 더 컸다면)
				if(!stack.isEmpty()) {
					int b = stack.pop();
					if( a!=b) {
						System.out.println("NO");
						flag = true;
						break;
					}else {
						sb.append("-").append("\n");
					}
				}
			}
		}
		if(!flag) {
			System.out.println(sb);
			
		}
	}
}
