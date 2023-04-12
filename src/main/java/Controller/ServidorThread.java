package Controller;

 // @author sergi
import com.mycompany.switch_application.connection.Servidor;


public class ServidorThread extends Thread {

    private int puerto;
    private Servidor servidor;

    public ServidorThread(int puerto, Servidor servidor) {
        this.puerto = puerto;
        this.servidor = servidor;
    }

    @Override
    public void run() {
        servidor.iniciar();
    }
}
