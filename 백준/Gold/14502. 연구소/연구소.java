import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
 
    static int n, m;
    static int[][] map;
    static int result = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" "); // 띄어쓰기 기준으로 배열에 넣기
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        
        // 입력값 받기
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s1[j]);
            }
        }
        dfs(0);
 
        System.out.println(result);
    }
 
    // 벽을 3번 세우면 bfs 돌리기
    public static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
 
        // 모든 영역 돌면서 0이면 벽 넣어보고 조건 만족하지 않으면 다시 0으로 되돌리기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
 
    public static void bfs() {
        int[][] virus_map = new int[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
 
        // 벽 3개를 세운 뒤 bfs를 돌면서 영역 갯수 세기
        // 맵 복제하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virus_map[i][j] = map[i][j];
            }
        }
 
        // 바이러스가 퍼진 영역이면 큐에 넣고 while문 돌리기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_map[i][j] == 2) {
                    queue.add(new int[] {i,j});
                }
            }
        }
 
        // 바이러스는 0으로 퍼져가기 때문에 0이면 2로 채우기
        // 2로 채워지면 해당 인덱스 큐에 넣고 다시 while문 돌리기
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[1] + dy[i];
                int nx = poll[0] + dx[i];
                if (ny >= 0 && nx >= 0 && nx < n && ny < m) {
                    if (virus_map[nx][ny] == 0) {
                        virus_map[nx][ny] = 2;
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
        count(virus_map);
    }
 
    // 안전한 영역 세기
    public static void count(int[][] virus_map) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_map[i][j] == 0) {
                    temp++;
                }
            }
        }
        result = Math.max(result, temp);
    }
}
 
