import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		int vertex,weight;
		Node next;
		
		public Node(int vertex, int weight, Node next) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.next = next;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int V= Integer.parseInt(st.nextToken());
		int E= Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine())-1;
		Node[] adjList = new Node[V]; // 인접 리스트
		int[] distance = new int[V]; // 시작점에서 자신으로 오는 최단거리
		boolean[] visited = new boolean[V]; // 방문 처리 리스트
		
		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adjList[start] = new Node(end, weight, adjList[start]);
		}
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		
		distance[K] = 0;
		int min=0, stopOver=0;
		for(int i=0; i<V; ++i){ // 모든 정점을 다 처리할때까지 반복
			
			stopOver = -1;
			min = INF;
			for(int j=0; j<V; ++j){
				if(!visited[j] &&  min > distance[j] ){
					min = distance[j];
					stopOver = j;
				}
			}
			if(stopOver == -1) break;
			
			visited[stopOver] = true;
			
			
			for(Node temp = adjList[stopOver]; temp != null; temp=temp.next) {
				if(!visited[temp.vertex] && distance[temp.vertex] > min+temp.weight){
					distance[temp.vertex] = min + temp.weight;
				}
			}
		}	
		for(int j = 0; j < V; j++) {
			if(distance[j] == INF) System.out.println("INF");
			else System.out.println(distance[j]);
		}
	}

}