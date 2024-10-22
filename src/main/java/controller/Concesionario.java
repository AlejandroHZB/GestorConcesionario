package controller;

import database.DBConnection;
import database.SchemaDB;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Concesionario {
    //Statement -> Query directa --> insert into empleados(nombre,apellido,correo,telefono) values ('Alejandro','Hernandez','alex@aaaa.es',12345)
        //TRUE OR FALSE --> CREATE
        //Nº DE FILAS AFECTADAS --> UPDATE O DELETE
    //PrepareStatement -> Query con Template -> insert into empleados(nombre,apellido,correo,telefono) values (?,?,?,?)
        //setInt(4,1234)
        //setString(1,"Alejandro")
        //setString(2,"Hernandez")
        //setString(3,"alejandro@asasa.es")


    //Create Update Delete --> Son lo mismo Modifican la tabla
    //Read --> Obtiene vector de valores





    //insertar trabajador

    public void insertarTrabajador(Empleado empleado){
        //Connection -> Statement (QUERY)-> EXECUTE
        Connection connection = new DBConnection().getConnection();
        //ya puedo acceder a la base de datos
        try {
            Statement statement = connection.createStatement();
            String psQuery = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)",
                    SchemaDB.TAB_EMP,
                    SchemaDB.COL_EMP_NAME,SchemaDB.COL_EMP_SURNAME,SchemaDB.COL_EMP_MAIL,SchemaDB.COL_EMP_PHONE);

            PreparedStatement preparedStatement =connection.prepareStatement(psQuery);
            preparedStatement.setString(1,"AlejandroPS");
            preparedStatement.setString(2,"HernandezPS");
            preparedStatement.setString(3,"correoPs@PS.es");
            preparedStatement.setInt(4,1234567);
            preparedStatement.executeUpdate();
        /*    String query = "INSERT INTO " + SchemaDB.TAB_EMP +
                    " (" + SchemaDB.COL_EMP_NAME+","+ SchemaDB.COL_EMP_SURNAME+","+ SchemaDB.COL_EMP_MAIL+","+ SchemaDB.COL_EMP_PHONE+") VALUES" +
                    "('"+empleado.getNombre()+"','"+empleado.getApellido()+"','"+empleado.getCorreo()+"','"+empleado.getTelefono()+")";  FUMADA GORDA

         %s String
         %d int
         %f double
         %b boolean
         %p char

         */
          //  String query = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%d')",
           //         SchemaDB.TAB_EMP,
            //        SchemaDB.COL_EMP_NAME,SchemaDB.COL_EMP_SURNAME,SchemaDB.COL_EMP_MAIL,SchemaDB.COL_EMP_PHONE,
             //       empleado.getNombre(),empleado.getApellido(),empleado.getCorreo(),empleado.getTelefono());

           // statement.execute(query); //si hay fallo o no
           // statement.executeUpdate(); // Cuantas filas afectadas
        } catch (SQLException e) {
            System.out.println("Error al crear Statement");
        }


    }

    public void borrarTrabajador(int id){

        Connection connection = new DBConnection().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + SchemaDB.TAB_EMP + " WHERE id = ?");
            preparedStatement.setInt(1,id);
            int row = preparedStatement.executeUpdate();
            System.out.println("Total de filas afectadas = " + row);
        } catch (SQLException e) {
            System.out.println("Error");
        }

    }

}

