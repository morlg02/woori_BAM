import java.util.Scanner;
 
 public class Main {
     
 	public static void main(String[] args) {
 		System.out.println("== 프로그램 시작 ==");
 		Scanner sc = new Scanner(System.in); // 최적화 => 자원 1번 사용 개선
        
 		while (true) {
 			System.out.printf("cmd) ");
 			String cmd = sc.nextLine(); // cmd 변수 ==> 재사용 하기 위해
 			System.out.println("명령어) " + cmd);
 			if (cmd.equals("exit")) {
 //	        if (cmd == "exit") {
 				break;
 			}
 
 		}
 		sc.close();
 		System.out.println("== 프로그램 종료 ==");
 
 	}
 
 }