package org.JavaBco;

import java.sql.Connection;
import java.sql.SQLException;

public class CrudDataBase extends DatabaseConnection {


    public static void createDatabase() throws SQLException { // ADICIONAR INFORMAÇÕES NO BANCO
        Connection conn = getConexao();
        DatabaseConnection.testarConexao();

    }
    public static void readDataBase(){ // VER OS ARQUIVOS NO BANCO

    }
    public static void UpdateDataBase(){ // MODIFICAR OS ARQUIVOS DO BANCO

    }
    public static void deleteDataBase(){ // DELETAR ARQUIVOS NO  BANCO

    }




}
