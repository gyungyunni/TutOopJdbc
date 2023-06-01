import model.BaseDAO;

import java.sql.*;


// 변경된 부분 ------- BaseDAO를 extends로 상속을 받는다 ------------------------
public class DBMain extends BaseDAO {
    // ----------------------------------------------------------------------------
    public static void main(String[] args) {
// 변경된 부분 ------- static을 빼주었기 때문에 인스턴스화 하여 사용하여한다.-----
        DBMain dbMain = new DBMain();
        dbMain.initPerson();
//        dbMain.getCodeName();
//-----------------------------------------------------------------------------
    }

    private void initPerson() {
        // 위 방법과 아래 방법 아무거나 상관없스
        String sql =
                "create table person (id integer primary key autoincrement, name string)";

        try {
            getConn();
            smt = conn.createStatement();
            smt.setQueryTimeout(30);  // set timeout to 30 sec.
            smt.executeUpdate("drop table if exists person");
            smt.executeUpdate(sql);
            smt.executeUpdate("insert into person(name) values('leo')");
            smt.executeUpdate("insert into person(name) values('yui')");
            rs = smt.executeQuery("select * from person");

            while(rs.next())
            {
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            close();
        }
    }
    private void getCodeName() {
        String sql = "select code, name from country order by code, name";

        try {
// 변경된 부분 ----------------------------------------------------------------
            getConn();
// ----------------------------------------------------------------------------
            psmt = conn.prepareStatement(sql);
            rs = psmt.executeQuery();
            while( rs.next() ) {
                System.out.print( rs.getString("code") + " ");
                System.out.println( rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
// 변경된 부분 -----------------------------------------------------------------
            close();
// ----------------------------------------------------------------------------
        }
    }
}