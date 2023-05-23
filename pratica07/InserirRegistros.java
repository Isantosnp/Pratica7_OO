package pratica07;

import java.sql.*;

public class InserirRegistros {

    private final String url = "jdbc:postgresql://localhost/BDLivrariaUniversitaria";
    private final String user = "postgres";
    private final String password = "586933";


    private static final String INSERT_LIVRO_SQL = "INSERT INTO livros" +
            "  (id, categoria, editora, titulo, publicacao, edicao, volume, preco, foto_capa) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        public void insertRecord() throws SQLException {
            System.out.println(INSERT_LIVRO_SQL);
            // Step 1: Establishing a Connection
            try (Connection connection = DriverManager.getConnection(url, user, password);

                 // Step 2:Create a statement using connection object
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIVRO_SQL)) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setInt(2, 1);
                preparedStatement.setInt(3, 3);
                preparedStatement.setString(4, "The last of US");
                preparedStatement.setDate(5, Date.valueOf("25/02/2023"));
                preparedStatement.setInt(6, 3);
                preparedStatement.setDouble(7, 39.90);
                preparedStatement.setBoolean(8, false);


                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
            } catch (SQLException e) {

                // print SQL exception information
                printSQLException(e);
            }

            // Step 4: try-with-resource statement will auto close the connection.
        }
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
