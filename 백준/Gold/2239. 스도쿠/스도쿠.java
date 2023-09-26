import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean check;
    static List<int[]> zerolist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        zerolist = new ArrayList<>();

        // 스도쿠 map 입력받기
        for (int i = 0; i < 9; i++) {
            String[] str = br.readLine().split(""); // 입력값이 띄어쓰기가 없으므로 한줄로 입력 받음
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(str[j]); // 문자열에서 하나씩 접근해서 map에 저장
                if (map[i][j] == 0) {
                    zerolist.add(new int[] {i,j}); // 0일 경우 zerolist에 좌표로 저장
                }
            }
        }
        sudoku(0);

        // 완성된 스도쿠 출력
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(String.valueOf(map[i][j]));
            }
            System.out.println();
        }

    }

    static void sudoku(int idx) {
        // 스도쿠 빈칸을 모두 채운다면
        if (idx == zerolist.size()) {
            check = true;
            return;
        }

        int[] current = zerolist.get(idx);
        for (int i = 1; i <= 9; i++) {
            map[current[0]][current[1]] = i; // 우선 1~9 숫자 넣기
            // 스도쿠 성립의 3가지 조건을 검사
            if (square(current[0], current[1]) && horizontal(current[0], current[1]) && vertical(current[0], current[1])) {
                sudoku(idx + 1); // 맞다면 다음 zerolist의 좌표값 진행
            }
            if (check) { // 빈칸 모두를 채웠다면 return
                return;
            }
            map[current[0]][current[1]] = 0; // 위 과정을 다 수행하고도 값을 채우지 못했다면 0으로 만들기
        }
    }

    // 3x3 영역 검사
    static boolean square(int x, int y) {
        int sx = (x / 3) * 3; // 0~2, 3~5, 6~8 영역으로 나누기 위함
        int sy = (y / 3) * 3; // 0~2, 3~5, 6~8 영역으로 나누기 위함

        for (int i = 0; i < 3; i++) { // 영역의 수 sx + (0,1,2)를 통해 인덱스 접근
            for (int j = 0; j < 3; j++) { // 영역의 수 sy + (0,1,2)를 통해 인덱스 접근
                if (x != sx + i || y != sy + j) {
                    if (map[sx + i][sy + j] == map[x][y]) { // 1~9 숫자가 중복되면 false
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // 세로 검사
    static boolean vertical(int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != x) {
                if (map[i][y] == map[x][y]) { // 세로로 숫자가 중복되면 false
                    return false;
                }
            }
        }

        return true;
    }

    // 가로 검사
    static boolean horizontal(int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != y) {
                if (map[x][i] == map[x][y]) { // 가로로 숫자가 중복되면 false
                    return false;
                }
            }
        }

        return true;
    }
}
