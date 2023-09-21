import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class classtime implements Comparable<classtime>{
		int start;
		int end;
		
		classtime(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(classtime c) {
			if(this.start == c.start) {
				return this.end - c.end;
			}else return this.start - c.start;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// classtime 타입의 배열을 선언함
		classtime[] classtimes = new classtime[N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 각 배열 인덱스에 객체를 입력값으로 넣기
			classtimes[i] = new classtime(start, end);
		}
		
		// 오름차순으로 정렬
		Arrays.sort(classtimes);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		// 종료시간 넣기
		pq.offer(classtimes[0].end);
		
        for (int i = 1; i < N; i++) {
        	
        	// 종료시간과 시작시간을 비교
            if (pq.peek() <= classtimes[i].start) {
                pq.poll();
            }
            pq.offer(classtimes[i].end);
        }
        
        System.out.println(pq.size());
	}

}
