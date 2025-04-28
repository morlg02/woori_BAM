import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 public class Main {
 	public static void main(String[] args) {
 		System.out.println("== 프로그램 시작 ==");
 		Scanner sc = new Scanner(System.in); 
 
 		int id = 1;
 		List<Article> articles = new ArrayList<>();
 
 		while (true) {
 			System.out.printf("명령어) ");
 			String cmd = sc.nextLine().trim(); 
 
 
 			if (cmd.equals("exit")) {
 				break;
 			} 
 			if (cmd.length() == 0) {
 				System.out.println("명령어를 입력해 주세요");
 				continue;
 			}
 
 			if (cmd.equals("article list")) {
 				System.out.println("게시글이 없습니다");
 			} else if(cmd.equals("article write")){
 
 
 				System.out.printf("제목 : ");
 				String title = sc.nextLine().trim(); 
 				System.out.printf("내용 : ");
 				String body = sc.nextLine().trim(); 
 				
 //				Article article = new Article(); // 최적화 사용 안함,  article 은 지역변수
 				Article article = new Article(id,title,body); // 인자를 통해 생성자 호출
 				// 최적화 작업 : 생성자를 이용해서 초기화
 //				article.id = id;                 // 따라서 저장이 된거는 아님
 //				article.title = title;
 //				article.body = body;
 				
 				// 진짜 저장은 아래 문장을 통해서 진행됩니다
 				articles.add(article);  // List구조인 ArrayList 객체인 articles 저장
 				
 				// 최적화 2
 //				articles.add(new Article(id,title,body));
 				
 				System.out.println(id +"번글이 생성되었습니다");
 				id++;
 
 			// 추후 아래 else if문은 삭제 예정.  명령어 test로 articles 저장된 내용 확인
 			// articles은 ArrayList 자료구조로 인덱스를 가지고 객체수는 제한 없음	
 			} else if (cmd.equals("test")) {
 				for(int i =0 ; i < articles.size(); i++) {
 					System.out.println(articles.get(i).id);
 					System.out.println(articles.get(i).title);
 					System.out.println(articles.get(i).body);
 				}  // 여기까지 삭제 할 거에요
 				
 				
 			}else {
 				System.out.println("존재하지 않는 명령어 입니다");
 			}
 		}
 
 		sc.close();
 		System.out.println("== 프로그램 종료 ==");
 	}
 
 }
 class Article {
 	int id;
 	String title;
 	String body;
 	public Article(int id, String title, String body) {
 		this.id = id;
 		this.title = title;
 		this.body = body;
 	}
 }