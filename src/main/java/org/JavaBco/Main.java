package org.JavaBco;
import java.sql.Connection;
import java.sql.SQLException;


import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws SQLException {


            CrudDataBase.readDataBase("products"); // Ve todos os itens no banco de dados
            //CrudDataBase.AddData("products", 11, "Sabão em Pó", 5.90,"Limpeza" ); //Adiciona um item ao banco de dados
            //CrudDataBase.UpdateDataBase("products",11, "Sabão em Pó", 22.90, "Limpeza"); //Modifica um item no banco de daoos
            //CrudDataBase.deleteData("products",11); // Exclui um intem no banco de dados

    }
}

