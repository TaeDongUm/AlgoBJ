import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main{
    static final int INF = 1_000_000_000;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
 
        int[][] arr = new int[V + 1][V + 1];
 
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }
 
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
 
            arr[a][b] = c;
        }
 
        // 플로이드 와샬
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }
 
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
 
        int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }
 
                // 싸이클 파악
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }
 
        // ans가 초기값이면 사이클이 존재하지 않음.
        if(ans == INF) System.out.println(-1);
        else System.out.println(ans);
    }
 
}
