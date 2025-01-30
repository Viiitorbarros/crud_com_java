package org.JavaBco;
import java.sql.Connection;
import java.sql.SQLException;


import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws SQLException {


            CrudDataBase.readDataBase("products");
            //CrudDataBase.AddData("products", 11, "Sabão em Pó", 5.90,"Limpeza" );
            //CrudDataBase.UpdateDataBase("products",11, "Sabão em Pó", 22.90, "Limpeza");

    }
}

