package sample.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;

public class CancionesDAO {

    private int id_cancion;
    private  String nombre_canciones;
    private  int duracion;
    private  String portada;
    private int anio;
    private String letra;

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getNombre_canciones() {
        return nombre_canciones;
    }

    public void setNombre_canciones(String nombre_canciones) {
        this.nombre_canciones = nombre_canciones;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }


    public void INSERT(){
        try {

            String query = "INSERT INTO tbl_canciones (nombre_cancion, duracion, portada, anio, letra) " +
                    "VALUES('"+nombre_canciones+"', "+duracion+", '"+portada+"', "+anio+", '"+letra+"');";

            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }

    }  //MANDA DATOS

    public void UPDATE(){
        try {
            String query = "UPDATE tbl_canciones SET nombre_cancion = '"+nombre_canciones+"', duracion = "+duracion+", " +
                    "portada = '"+portada+"', anio = "+anio+", letra = '"+letra+"' WHERE id_cancion = "+id_cancion;

            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }

    }  //MANDA DATOS

    public void DELETE(){
        try {

            String query = "DELETE FROM tbl_canciones WHERE id_cancion = "+ id_cancion+";";
            Statement stmt = Conexion.conexion.createStatement();
            stmt.executeUpdate(query);

        }catch (Exception e){
            e.printStackTrace();
        }

    }  //ACTUALIZA LA BD

    public ObservableList<CancionesDAO> SELECT(){
        ObservableList<CancionesDAO> listC = FXCollections.observableArrayList();

        try {

            CancionesDAO objc;

            String query = "SELECT * FROM tbl_canciones ORDER BY nombre_cancion ASC";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet res = stmt.executeQuery(query);

            while (res.next()){
                objc = new CancionesDAO();
                objc.id_cancion = res.getInt("id_cancion");
                objc.nombre_canciones = res.getString("nombre_cancion");
                objc.duracion = res.getInt("duracion");
                objc.portada = res.getString("portada");
                objc.anio = res.getInt("anio");
                objc.letra = res.getString("letra");
                listC.add(objc);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  listC;
    }  //TRAE DATOS

}
