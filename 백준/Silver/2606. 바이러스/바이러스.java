import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int count=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		LinkedList<Integer>[] list = new LinkedList[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i=0;i<list.length;i++) {
			list[i] = new LinkedList<Integer>();
		}
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<list[1].size();i++) {
			stack.push(list[1].get(i));
		}
		visited[1] = true;
		while(!stack.isEmpty()) {
			int current = stack.pop();
			if(visited[current]) continue;
			visited[current] = true;
			count++;
			for(int j=0;j<list[current].size();j++) {
				stack.push(list[current].get(j));
			}
		}
		System.out.println(count);
	}

}
