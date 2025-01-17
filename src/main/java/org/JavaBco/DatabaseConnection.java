package org.JavaBco;
import java.sql.Connection; // importa nossa conexão com o banco de dados
import java.sql.DriverManager;
import java.sql.SQLException; //
public class DatabaseConnection {
    public static Connection getConexao() throws SQLException {

        String url  = "jdbc:mysql://localhost:3306/stock";
        String usuario = "root";
        String senha = "22021996" ;


        return DriverManager.getConnection(url,usuario,senha);

    }

}
