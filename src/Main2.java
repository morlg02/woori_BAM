public class Main2 {
 	public static void main(String[] args) {
 
 		String a = "asd";
 		String b = "asd";
 
 		System.out.println(a == b);      // 주소가 값은가?
 		System.out.println(a.equals(b)); // a.b 가진 값이 같은가?
 		
 		System.out.println("----------");
 		
 		String c  = new String("asd");
 		String d  = new String("asd");
 		System.out.println(c == d);      // 주소가 값은가?
 		System.out.println(c.equals(d)); // a.b 가진 값이 같은가?
 		
 	}
 
 }