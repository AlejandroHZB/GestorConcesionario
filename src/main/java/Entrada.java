import controller.Concesionario;
import database.DBConnection;
import model.Empleado;

import java.sql.Connection;

public class Entrada {
    public static void main(String[] args) {
       // DBConnection dbConnection = new DBConnection();
       // Connection connection = dbConnection.getConnection();
        //Trabajamos con la conexion

       // dbConnection.closeConenction();

       // DBConnection dbConnection2 = new DBConnection();
       // Connection connection2 = dbConnection2.getConnection();

        Concesionario concesionario = new Concesionario();
       // concesionario.insertarTrabajador(new Empleado("Alejandro", "Hernandez","aa@aa.es",1234));
        concesionario.borrarTrabajador(1);
    }
}
