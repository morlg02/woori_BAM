package jdbc;
import java.sql.*;

public class EmpWithSalgrade {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String password = "tiger";

        String sql = 
               "SELECT e.ename, e.sal, s.grade " +
               "FROM emp e JOIN salgrade s " +
               "ON e.sal BETWEEN s.losal AND s.hisal";

//jdk 15 이상부터 지원        
//        String sql = """
//            SELECT e.ename, e.sal, s.grade
//            FROM emp e
//            JOIN salgrade s
//            ON e.sal BETWEEN s.losal AND s.hisal
//            """;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("이름\t급여\t등급");
            while (rs.next()) {
                String ename = rs.getString("ename");
                double sal = rs.getDouble("sal");
                int grade = rs.getInt("grade");

                System.out.printf("%s\t%.2f\t%d%n", ename, sal, grade);
            }

            rs.close(); stmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
