package ma.elarbi.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {

    public static void viewTable(Connection con, String dbName) throws SQLException {

        Statement stmt = null;

        String query = "select id, firstname from " + dbName + ".PERSON";
        try {

            stmt = con.createStatement();
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
