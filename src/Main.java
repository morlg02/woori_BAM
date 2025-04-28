import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 public class Main {
 	public static void main(String[] args) {
 		System.out.println("== 프로그램 시작 ==");
 		Scanner sc = new Scanner(System.in); 
 
 		int lastArticleId = 1;  
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
 			if (cmd.equals("article write")) {
 
 				System.out.printf("제목 : ");
 				String title = sc.nextLine().trim(); 
 				System.out.printf("내용 : ");
 				String body = sc.nextLine().trim(); 
 
 				Article article = new Article(lastArticleId,title,body); 
 				articles.add(article); 
 
 				System.out.println(lastArticleId +"번글이 생성되었습니다");
 				lastArticleId++;
 
 			} else if(cmd.equals("article list")){
 
 				if (articles.size() == 0 ) {
 					System.out.println("존재하는 게시글이 없습니다");
 					continue;
 
 				}
 
 				System.out.printf("번호    |     제목\n");
 				for (int i = articles.size() -1 ; i >= 0; i--) {
 					Article article = articles.get(i);
 					System.out.printf("%d      |     %s\n", article.id, article.title);
 				}
 
 			} else if (cmd.startsWith("article detail ")) { 
 				String[] cmdBits = cmd.split(" ");
 
 				Article foundArticle = null;
 
 				int id = 0;
 
 				try { // Exception 발생 할 예상 코드 블럭
 					 id = Integer.parseInt(cmdBits[2]); 
 
 				} catch (NumberFormatException e) { // (예외타입 변수명)
 					System.out.println("정수를 입력하시길 바랍니다");
 					continue;  // 이하 실행이 안되도록 ==> while 작동
 				} catch (Exception e)	 {
 					// 그밖에 모든 Exception 처리한다
 				}
 
 				for (Article article : articles) {
 					if (article.id == id) {  
 						foundArticle = article ;
 						break;
 					}
 				}
 
 				if (foundArticle == null) {
 					System.out.println(id + "번 게시물이 존재하지 않습니다");
 					continue;     
 				}
 
 				System.out.println("번호 : " + foundArticle.id);
 				System.out.println("날짜 : ~~~");
 				System.out.println("제목 : " + foundArticle.title);
 				System.out.println("내용 : " + foundArticle.body);
 
 				
 			} else if (cmd.startsWith("article delete ")) { 
 				String[] cmdBits = cmd.split(" ");  // 재 사용? Y
 				
 				Article foundArticle = null;  // Y
 				
 				int id = 0; // Y
 			
 				// 재사용 Y
 				try { // Exception 발생 할 예상 코드 블럭
 					id = Integer.parseInt(cmdBits[2]); 
 					
 				} catch (NumberFormatException e) { // (예외타입 변수명)
 					System.out.println("정수를 입력하시길 바랍니다");
 					continue;  // 이하 실행이 안되도록 ==> while 작동
 				} catch (Exception e)	 {
 					// 그밖에 모든 Exception 처리한다
 				}
 				
 				int foundIndex = -1; // null 과 개념, -1 초기화
 				int indexId = 0;		
 
 				// 재사용 Y  , 향상된 FOR문 인텍스 사용 X, 일반 FOR문 사용 -> 수정
 				for (Article article : articles) {
 					if (article.id == id) {  
 						foundArticle = article ;
 						foundIndex = indexId; 
 						break;
 					}
 					indexId++;
 				}
 				
 				// 인덱스 방식
 //				for (int i = 0; i < articles.size(); i++) {
 //					Article article = articles.get(i);
 //					if (article.id == id) {  
 //						break;
 //					}
 //			
 //				}
 				
 				if (foundArticle == null) {
 					System.out.println(id + "번 게시물이 존재하지 않습니다");
 					continue;     
 				}
 				
 			    articles.remove(foundArticle); // 2가지 방법이 있음 remove(객체)
 //			    articles.remove(foundIndex);   // 상동 remove(인덱스)
 			    
 			    System.out.println(foundArticle.id + "번 게시물이 삭제 되었습니다");
 				
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