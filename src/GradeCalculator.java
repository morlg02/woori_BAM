import java.util.Scanner;
 
 public class GradeCalculator {
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         final int STUDENT_COUNT = 5; // 학생 수
         String[] names = new String[STUDENT_COUNT];
         int[] scores = new int[STUDENT_COUNT];
         String[] grades = new String[STUDENT_COUNT];
 
         // 학생 정보 입력
         for (int i = 0; i < STUDENT_COUNT; i++) {
             System.out.println("\n[" + (i + 1) + "번째 학생]");
 
             System.out.print("이름: ");
             names[i] = scanner.nextLine();
 
             System.out.print("점수: ");
             scores[i] = scanner.nextInt();
             scanner.nextLine(); // 줄바꿈 처리
 
             // 등급 계산 (switch 사용)
             switch (scores[i] / 10) {
                 case 10:
                 case 9:
                     grades[i] = "A";
                     break;
                 case 8:
                     grades[i] = "B";
                     break;
                 case 7:
                     grades[i] = "C";
                     break;
                 case 6:
                     grades[i] = "D";
                     break;
                 default:
                     grades[i] = "F";
                     break;
             }
         }
 
         // 결과 출력
         System.out.println("\n📋 학생별 등급 결과");
         for (int i = 0; i < STUDENT_COUNT; i++) {
             System.out.println(names[i] + " 학생의 점수: " + scores[i] + ", 등급: " + grades[i]);
         }
 
         scanner.close();
     }
 }