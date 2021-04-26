package sample.models;

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

    }  //MANDA DATOS
    public void UPDATE(){

    }  //MANDA DATOS
    public void DELETE(){

    }  //ACTUALIZA LA BD
    public void SELECT(){

    }  //TRAE DATOS

}
