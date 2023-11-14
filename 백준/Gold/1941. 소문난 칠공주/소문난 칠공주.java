import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final char[][] map = new char[5][5];
    private static final boolean[][] visited = new boolean[5][5];
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int caseCount = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        dfs(0, 0); //7자리를 선택한다.
        System.out.println(caseCount);
    }

    private static void dfs(int depth, int start) {
        if (depth == 7) {
            if (checkLinked()) caseCount++;
        } else {
            //25개의 자리중 7개를 선택한다 
            for (int i = start; i < 25; i++) {
                visited[i / 5][i % 5] = true;
                dfs(depth + 1, i + 1);
                visited[i / 5][i % 5] = false;
            }
        }
    }

    private static boolean checkLinked() {
        //연속된 7자리에 대해서 copy
        boolean[][] copyVisited = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            copyVisited[i] = visited[i].clone();
        }

        int x = 0, y = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (copyVisited[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }
        
        //연속된 7자리인지, 이다솜파 과반수 이상인지 확인
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        
        int cnt = 0;
        int s = 0;
        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int[] dir : dirs) {
                int nx = point.x + dir[0];
                int ny = point.y + dir[1];

                if (0 > nx || 5 <= nx || 0 > ny || 5 <= ny) {
                    continue;
                }
                
                if (copyVisited[nx][ny]) {
                    if (map[nx][ny] == 'S') s++; //이다솜파
                    cnt++; //연결된사람들 확인
                    q.add(new Point(nx, ny));
                    copyVisited[nx][ny] = false; //방문확인
                }
            }
        }
        if (cnt == 7 && 4 <= s) { //7개가 연속으로 이어져 있는지, 이다솜파가 4명(과반수 이상인지)
            return true;
        }
        return false;
    }
}
