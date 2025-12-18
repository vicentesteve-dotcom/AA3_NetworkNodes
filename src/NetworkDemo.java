public class NetworkDemo {
    public static void main(String[] args) {
        Red red = new Red();

        Nodo atacante = new Nodo("Atacante", "10.0.0.66", false, false);
        Nodo wifi     = new Nodo("WiFi",     "10.0.0.1",  false, false);
        Nodo fw       = new Nodo("Firewall", "10.0.0.254", true,  false);
        Nodo web      = new Nodo("WebServer","172.16.0.10", false, true);
        Nodo db       = new Nodo("DBServer", "172.16.0.20", false, false);

        red.agregarNodo(atacante);
        red.agregarNodo(wifi);
        red.agregarNodo(fw);
        red.agregarNodo(web);
        red.agregarNodo(db);

        red.conectar(atacante, wifi);
        red.conectar(wifi, fw);
        red.conectar(fw, web);
        red.conectar(web, db);

        red.mostrar();

        System.out.println("\n=== ESCANEO DESDE ATACANTE ===");
        red.escanearDesde(atacante);
        red.mostrar();

        System.out.println("\nVecinos de WebServer: " + red.listarVecinosDe(web));
        System.out.println("Buscar IP 172.16.0.20: " + red.buscarPorIP("172.16.0.20"));
        System.out.println("Vulnerables alcanzables desde atacante: " + red.contarVulnerablesAlcanzables(atacante));
        System.out.println("Nodos aislados: " + red.nodosAislados());
    }
}