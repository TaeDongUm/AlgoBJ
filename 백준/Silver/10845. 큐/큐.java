import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Deque<Integer> q = new ArrayDeque();
		int N = Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			if(line.equals("push")) {
				int a = Integer.parseInt(st.nextToken());
				q.add(a);
			}
			else if(line.equals("pop")) {
				if(!q.isEmpty()) {
					System.out.println(q.poll());
				}
				else {
					System.out.println(-1);
				}
			}
			else if(line.equals("size")) {
				System.out.println(q.size());
			}
			else if(line.equals("empty")) {
				if(q.isEmpty()) System.out.println(1);
				else {
					System.out.println(0);
				}
			}
			if(line.equals("front")) {
				if(!q.isEmpty()) System.out.println(q.peek());
				else {
					System.out.println(-1);
				}
			}
			if(line.equals("back")) {
				if(!q.isEmpty()) System.out.println(q.peekLast());
				else {
					System.out.println(-1);
					
				}
			}
		}
	}

}