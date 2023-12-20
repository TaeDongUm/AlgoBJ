import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] arr, printArr;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws Exception{
			Scanner sc = new Scanner(System.in);
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N];
			printArr = new int[M];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			sc.close();
			
			Arrays.sort(arr);
			
			dfs(0, 0);
			
			System.out.println(sb);
	}
	
	static void dfs(int start, int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(printArr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			printArr[depth] = arr[i];
			dfs(i + 1, depth + 1); 
		}
	}
}