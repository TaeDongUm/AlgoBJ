import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		for(int i=0;i<input.length();i++) {
			if('A' <=input.charAt(i) && input.charAt(i) <='Z') {
				System.out.print((char)('a' + input.charAt(i) - 'A'));
			}else {
				System.out.print((char)('A' + input.charAt(i) - 'a'));
			}
		}
	}

}
