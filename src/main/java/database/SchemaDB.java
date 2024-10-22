package database;

public interface SchemaDB {

    //1.Una interfaz conecta dos clases que no tienen nada que ver
    // con los metodos abstractos de dicha interfaz

    //2. Almacen de constantes variables(no de metodos)
    String DB_NAME = "concesionario";
    String TAB_EMP = "empleados";
    String COL_ID = "id";
    String COL_EMP_NAME = "nombre";
    String COL_EMP_SURNAME = "apellido";
    String COL_EMP_MAIL = "correo";
    String COL_EMP_PHONE = "telefono";




}
