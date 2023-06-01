package model;

import java.sql.*;

public class BaseDAO {
    protected Connection conn = null;
    protected Statement smt = null;
    protected PreparedStatement psmt = null;
    protected ResultSet rs = null;

    //connection 연결 메소드
    protected void getConn() throws SQLException {
        String url = "jdbc:sqlite:world.db";
        String user = ""; // 지금은 사용 안함.
        String psw = "";  // 지금은 사용 안함.

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //자원 반환 메소드
    protected void close() {
        try {
            if (rs != null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            if (psmt != null) smt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            if (psmt != null) psmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } try {
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}