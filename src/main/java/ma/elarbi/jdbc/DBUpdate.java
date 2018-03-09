package ma.elarbi.jdbc;

import java.sql.*;

public class DBUpdate {

    //https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

    public static void main(String[] args) throws SQLException {

        String connURL = "jdbc:mysql://localhost:3306/dari?user=root&password=manager&useSSL=false";
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(connURL);
            Statement statement = conn.createStatement();
            statement.execute(QUERIES.INSERT_INTO_PERSON);

            DBHelper.viewTable(conn, "dari");


        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            conn.close();
        }

    }


}
