package ma.elarbi.jdbc;

import java.sql.*;

public class DBHelper {
    public static final String CONN_URL = "jdbc:mysql://localhost:3306/dari?user=root&password=manager&useSSL=false";

    public static void viewTable(String dbName, String tableName) throws SQLException {

        Statement stmt = null;

        String query = "select id, firstname from " + dbName + "." + tableName;
        try {

            Connection connection = DriverManager.getConnection(CONN_URL);

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String firstname = rs.getString("FIRSTNAME");

                System.out.println(id + "\t" + firstname);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }
}
