import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		int index =0;
		sb.append("<");
		while(list.size()>0) {
			if(list.size()==1) {
				sb.append(list.get(0));
				break;
			}
			index = index + K-1;
			if(index>=list.size()) index = index % list.size();
			sb.append(list.get(index)).append(", ");
			list.remove(index);
			if(index>=list.size()) index = index % list.size();
		}
		sb.append(">");
		System.out.println(sb);
	}

}
