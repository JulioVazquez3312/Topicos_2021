package sample.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteSoke {

    private Socket clinete;
    private InetAddress host;

    public void connectToServer(){
        try{
            host = InetAddress.getLocalHost();
            clinete = new Socket(host, 5000);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clinete.getInputStream()));
            System.out.println(entrada.readLine());

            PrintStream salida = new PrintStream(clinete.getOutputStream());
            salida.println("Hola gracias por el saludo :)");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
