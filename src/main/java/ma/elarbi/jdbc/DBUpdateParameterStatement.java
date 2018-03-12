package ma.elarbi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUpdateParameterStatement {


    public static void main(String[] args) throws SQLException {

        String connURL = "jdbc:mysql://localhost:3306/dari?user=root&password=manager&useSSL=false";

        try (Connection conn = DriverManager.getConnection(connURL);) {


            PreparedStatement preparedStatement = conn.prepareStatement(QUERIES.INSERT_INTO_PERSON_WITH_PARAMETER);
            preparedStatement.setString(1, "Mohammed");


            preparedStatement.execute();

            DBHelper.viewTable("dari", "PERSON");


        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
