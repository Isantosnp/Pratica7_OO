package pratica07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BuscaLivros {
    private static final String SELECT_LIVROS_SQL = "select from livros where titulo = ?;";

    private final String url = "jdbc:postgresql://localhost/BDLivrariaUniversitaria";
    private final String user = "postgres";
    private final String password = "586933";
    \\
    public void deleteRecord() throws SQLException {
        System.out.println(SELECT_LIVROS_SQL);

        // Step 1: Establishing a Connection
        try (Connection connection = DriverManager.getConnection(url, user, password);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIVROS_SQL);) {
            preparedStatement.setString(1, SELECT_LIVROS_SQL);


            // Step 3: Execute the query or update query
            int result = preparedStatement.executeUpdate();

            while (result.next()) {
                // Ler os dados das colunas
                int id = re.getInt("id");
                String nome = resultSet.getString("nome");
                // ... ler outros atributos da tabela

                // Exibir os dados encontrados
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                // ... exibir outros atributos da tabela
                System.out.println();

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




}
