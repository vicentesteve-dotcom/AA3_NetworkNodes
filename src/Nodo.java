import java.util.ArrayList;

public class Nodo {
    String nombre;
    String ip;
    boolean firewall;
    boolean vulnerable;
    boolean comprometido;
    ArrayList<Nodo> vecinos;

    Nodo(String nombre, String ip, boolean firewall, boolean vulnerable) {
        // TODO: Realizar constructor
    }

        
    void conectar(Nodo otro) {
        // TODO: conecta este nodo con "otro" (sin duplicados)
    }

    @Override
    public String toString() {
        // TODO: devolver algo tipo:
        // "WebServer (172.16.0.10) [VULN] [PWN]" etc.
        return "";
    }
}