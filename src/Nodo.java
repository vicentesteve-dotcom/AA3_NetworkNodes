import java.util.ArrayList;

public class Nodo {
    String nombre;
    String ip;
    boolean firewall;
    boolean vulnerable;
    boolean comprometido;
    ArrayList<Nodo> vecinos;
    boolean propagacion;


    Nodo(String nombre, String ip, boolean firewall, boolean vulnerable) {
        // TODO: Realizar constructor
        vecinos = new ArrayList<>();
        this.nombre = nombre;
        this.ip = ip;
        this.firewall = firewall;
        this.vulnerable = vulnerable;
        this.comprometido = false;
        this.propagacion = true;

    }

        
    void conectar(Nodo otro) {
        // TODO: conecta este nodo con "otro" (sin duplicados)
        if(!vecinos.contains(otro) && propagacion == true) {
            vecinos.add(otro);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public boolean getFirewall() {
        return firewall;
    }

    public boolean getVulnerable() {
        return vulnerable;
    }

    public ArrayList<Nodo> getVecinos() {
        return vecinos;
    }

    public void setComprometido(boolean c) {
        this.comprometido = c;
    }

    public void setPropagacion(boolean propagacion) {
        this.propagacion = propagacion;
    }



    @Override
    public String toString() {
        // TODO: devolver algo tipo:
        // "WebServer (172.16.0.10) [VULN] [PWN]" etc.
        String exit = nombre;
        exit += " (" + ip + ")";
        exit += " [ Firewall: " + firewall + "]";
        exit += " [ Vulnerable: " + vulnerable + "]";
        exit += " [ Comprometido: " + comprometido + "]";
        return exit;
    }
}