package org.JavaBco;

import java.sql.*;

public class CrudDataBase extends DatabaseConnection {


    public static void createDatabase(String tabela) throws SQLException { // ADICIONAR INFORMAÇÕES NO BANCO

        String query = "Select * From " + tabela; // Consulta para obter todos os registros da tabela

        // a conexão com o banco esta vindo de DatabaseConnection
        testarConexao(); // testa a conexao com o banco



        try (Connection conn = getConexao(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            // Obtém os 'metadados' do resultado para acessar informações das coluna


            // Verifica se o ResultSet está vazio antes de iterar
            if (!rs.isBeforeFirst()) { // Se não há dados no ResultSet
                System.out.println("A tabela " + tabela + " está vazia =(");
                return; // Sai do método se a tabela estiver vazia
            }


            ResultSetMetaData metaData = rs.getMetaData();// fornece uma forma de obter metadados sobre o ResultSet
            int numeroTotalDeColunas = metaData.getColumnCount();


            while (rs.next()) {


                // Para cada coluna, obtém o nome e o valor
                for(int i = 1; i <= numeroTotalDeColunas; i++ ){

                   String valorColuna = metaData.getColumnName(i);
                   Object valorObjeto  = rs.getObject(i);

                    System.out.println(valorColuna +": " +  valorObjeto );

                }

                System.out.println("------------------------------------");


            }

        }catch(SQLException e){

            // Trata erros relacionados ao banco de dados
            System.out.println("Erro ao listar itens: " + e.getMessage());

        }


    }


    public static void readDataBase(){ // VER OS ARQUIVOS NO BANCO

    }
    public static void UpdateDataBase(){ // MODIFICAR OS ARQUIVOS DO BANCO

    }
    public static void deleteDataBase(){ // DELETAR ARQUIVOS NO  BANCO

    }




}
