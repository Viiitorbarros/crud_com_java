package org.JavaBco;
import java.sql.Connection;
import java.sql.SQLException;


import java.sql.Connection;

public class Main {

    public static void main(String[] args) {


        try {

            Connection conn = DatabaseConnection.getConexao();
            System.out.println("Conexão bem-sucedida");

        } catch (SQLException e) {

            System.out.println("Erro ao conectar: " + e.getMessage());

        }

    }
}