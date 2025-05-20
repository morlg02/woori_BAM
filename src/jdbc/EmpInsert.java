package jdbc;

import java.sql.*;

public class EmpInsert {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String password = "tiger";
        // SYSDATE --> 현재 날짜 + 시간
        String sql = "INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) " +
                     "VALUES (?, ?, ?, ?, SYSDATE, ?, ?, ?)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            // SQL 문을 미리 준비하고, 파라미터만 바인딩하여 실행하는 객체
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 9001);               // empno
            pstmt.setString(2, "JUNHO");         // ename
            pstmt.setString(3, "ANALYST");       // job
            pstmt.setInt(4, 7566);               // mgr
            pstmt.setDouble(5, 3200.0);          // sal
            pstmt.setDouble(6, 0.0);             // comm
            pstmt.setInt(7, 20);                 // deptno

            int result = pstmt.executeUpdate();
            System.out.println(result + "건이 입력되었습니다.");

            pstmt.close(); conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
