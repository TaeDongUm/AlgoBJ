import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());

		for (int i = 0; i < a; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int b = Integer.parseInt(br.readLine());
			for (int j = 0; j < b; j++) {
				String key = br.readLine().split(" ")[1];
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}
			int x = 1;
			for (int y : map.values()) {
				x *= y + 1;
			}
			System.out.println(x-1);
		}
	}
}