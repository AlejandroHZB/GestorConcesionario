package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;
    // si alguien pide una cenexion
    // si está --> se la doy
    //si no está --> la creo

    public Connection getConnection(){
        if(connection==null){
            newConnection();
        }
        return connection;
    }

    private void newConnection() {

        //uri de conexion
        String url = "jdbc:mysql://localhost:3306/concesionario";
        try {

            connection = DriverManager.getConnection(url,"root","");
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos");
        }
        System.out.println("Conexion creada correctamente");

    }

    public void closeConenction(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion a la base de datos");
        }finally {
            connection = null;
        }
    }

}
