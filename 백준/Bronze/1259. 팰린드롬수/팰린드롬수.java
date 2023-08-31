import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
            boolean flag=true;
			String line = sc.nextInt()+"";
			if(line.equals("0")) break;
			for(int i=0;i<line.length()/2;i++) {
				if(line.charAt(i) != line.charAt(line.length()-1-i)) {
					System.out.println("no");
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("yes");
			}
			
		}
	}

}
