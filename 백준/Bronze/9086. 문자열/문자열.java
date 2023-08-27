import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(st.nextToken());
        //sc.nextInt();
        for(int i = 0;i<N;i++){
            String line;
            //sc.nextLine();
            line = br.readLine();
            int length = line.length();
            if(length !=0){
                System.out.print(line.charAt(0));
                System.out.print(line.charAt(length-1));
            }
            else {
                System.out.print(line);
            }
            System.out.print("\n");
        }
    }
}