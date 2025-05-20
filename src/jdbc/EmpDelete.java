package jdbc;
import java.sql.*;

public class EmpDelete {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String password = "tiger";

        String sql = "DELETE FROM emp WHERE empno = ?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 9001);

            int result = pstmt.executeUpdate();
            System.out.println(result + "건 삭제 완료");

            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

