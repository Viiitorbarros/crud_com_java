package org.JavaBco;

import java.sql.*;

public class CrudDataBase extends DatabaseConnection {


    public static void readDataBase(String tabela){ // VER OS ARQUIVOS NO BANCO throws SQLException { //VER OS ARQUIVOS NO BANCO

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


    public static void AddData(String tabela, int id,String nome, double preco, String categoria){ // ADICIONA ARQUIVOS NO BANCO

        String query = "INSERT INTO " + tabela + " (id, nome, preco, categoria) VALUES (?,?,?,?)";  // Query para adiconar os produtos

        // a conexão com o banco esta vindo de DatabaseConnection
        testarConexao(); // testa a conexao com o banco

        try (Connection conn = getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Define os parâmetros para a query / os stmt's seguem a ordem dos - >?
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setDouble(3,preco);
            stmt.setString(4, categoria);

            // Executa a inserção
            int rowsAffected = stmt.executeUpdate(); // Retorna o número de linhas afetadas essa é a função do executeUptade

            if (rowsAffected > 0) {
                System.out.println("Dados inseridos com sucesso!");
            } else {
                System.out.println("Falha ao inserir dados.");
            }

        } catch (SQLException e) {
            // Trata erros relacionados ao banco de dados
            System.out.println("Erro ao adicionar dados: " + e.getMessage());
        }
    }

    public static void UpdateDataBase(String tabela, int id , String nome , double preco, String categoria){ // MODIFICAR OS ARQUIVOS DO BANCO

        String query = "UPDATE " + tabela + " SET nome = ?, preco = ?, categoria = ? WHERE id = ?";

        try (Connection conn = getConexao();
        PreparedStatement stmt = conn.prepareStatement(query) ){

            stmt.setString(1,nome);
            stmt.setDouble(2,preco);
            stmt.setString(3,categoria);
            stmt.setInt(4,id);

            int rowsAffected = stmt.executeUpdate(); // Retorna o número de linhas afetadas essa é a função do executeUptade

            if (rowsAffected > 0){

                System.out.println("Registro atualizado com sucesso!");
            }else {
                System.out.println("Nenhum registro encontrado para atualizar.");
            }


        }catch (SQLException e) {

            System.err.println("Erro ao atualizar o banco de dados: " + e.getMessage());

        }

    }
    public static void deleteData(String tabela, int id){ // DELETAR ARQUIVOS NO  BANCO pelo ID

        String query = "DELETE FROM " + tabela + "  WHERE id = ?";

        try(Connection conn = getConexao();
        PreparedStatement stmt = conn.prepareStatement(query);){

            stmt.setInt(1,id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected >0){
                System.out.printf("Dados exluidos com sucesso");
            }else {

                System.out.printf("Error ao excluir Dados");
            }

        }catch (SQLException e){

            System.out.printf("Não foi possivel delatar os dados selecionados: " + e.getMessage());

        }
    }

}
