package ma.elarbi.jdbc;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DBUpdate {
    public static final String SCHEMA_NAME = "dari";
    private static final String PERSON_TABLE_NAME = "PERSON";

    //https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.html

    public static void main(String[] args) throws SQLException {
        String firstName = "TOTO";

        List<String> personFirstNames = Arrays.asList("Mohammed", "Issam", "Lamia");

        Connection conn = DriverManager.getConnection(DBHelper.CONN_URL);
        for (String personFirstName : personFirstNames) {

            PreparedStatement statement = conn
                    .prepareStatement(QUERIES.INSERT_INTO_PERSON_WITH_PARAMETER);

            statement.setString(1, personFirstName);
            statement.execute();

        }
        DBHelper.viewTable(SCHEMA_NAME, PERSON_TABLE_NAME);
    }


    private static void insertPerson(String firstName) throws SQLException {


        try (Connection conn = DriverManager.getConnection(DBHelper.CONN_URL)) {//Créer une connexion vers la BD mysql avec l'url

            //Créer un objet Statement pour lancer une requete vers ma BD
            PreparedStatement statement = conn
                    .prepareStatement("INSERT INTO PERSON(firstname) VALUES (?)");

            statement.setString(1, firstName);

            //Première requet d'insert d'un enregistrement
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
