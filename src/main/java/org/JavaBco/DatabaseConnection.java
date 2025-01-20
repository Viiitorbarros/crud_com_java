package org.JavaBco;
import java.sql.Connection; // importa nossa conexão com o banco de dados
import java.sql.DriverManager;
import java.sql.SQLException; //
public class DatabaseConnection {
    public static  Connection getConexao() throws SQLException { // Metodo para conectar ao BANCO

        String url  = "jdbc:mysql://localhost:3306/stock"; // Url do banco
        String usuario = "root";// usuario do banco
        String senha = "22021996" ; // senha do banco


        return DriverManager.getConnection(url,usuario,senha);

    }
    public static void testarConexao() { // metodo para testar a conexão

        try (Connection conn = getConexao()) {

            if (conn != null) {
                System.out.printf("Conexão bem-sucedida");
            }

        } catch (SQLException e) {

            System.out.printf("Erro ao conectar ao banco " + e.getMessage());

        }
    }



}
