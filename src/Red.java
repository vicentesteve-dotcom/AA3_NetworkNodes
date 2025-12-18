 import java.util.ArrayList;

 public class Red {
        private ArrayList<Nodo> nodos;

        Red() {
             nodos = new ArrayList<>();
        }

        void agregarNodo(Nodo n) {
            if(!nodos.contains(n)){
                nodos.add(n);
            }
        }

        void conectar(Nodo a, Nodo b) {
            a.conectar(b);
            b.conectar(a);
        }

        
        void mostrar() {
            System.out.println("=== GRAFO ===");
            for (Nodo n : nodos){
                System.out.println(n.getNombre() + " --> " + n.getVecinos());
            }
        }
        
        void resetCompromisos() {
            for (Nodo n : nodos){
                n.setComprometido(false);
            }
        }

        void escanearDesde(Nodo origen) {
            // TODO: BFS desde origen - https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/
            // Reglas:
            // - si un nodo visitado es vulnerable => comprometido=true
            // - si un nodo visitado es firewall => NO se propaga a sus vecinos
            for(Nodo n : nodos){
                if(n.getVulnerable() == true){
                    n.setComprometido(true);
                }
                if(n.getFirewall() == true){
                    n.setPropagacion(false);
                }
            }
        }

        Nodo buscarPorIP(String ip) {
            for(Nodo n : nodos){
                if (n.getIp().equals(ip)){
                    return n;
                }
            }
            return null;
        }
  
        int contarVulnerablesAlcanzables(Nodo origen) {
            ArrayList<Nodo> pila = new ArrayList<>();
            ArrayList<Nodo> nodosContats = new ArrayList<>();

            pila.add(origen);
            nodosContats.add(origen);

            int totalVuln = 0;

            while (!pila.isEmpty()) {
                Nodo actual = pila.remove(pila.size() - 1);

                for (Nodo vecino : actual.getVecinos()) {
                    if (!nodosContats.contains(vecino)) {
                        nodosContats.add(vecino);
                        pila.add(vecino);

                        if (vecino.getVulnerable()) {
                            totalVuln++;
                        }
                    }
                }
            }
            return totalVuln;
        }



        String listarVecinosDe(Nodo n) {
            String tmp = "";
            for(Nodo v: n.getVecinos()){
                tmp += v.getNombre() + ", ";
            }
            return tmp;
        }

        ArrayList<Nodo> nodosAislados() {
            // Obtener nodos aislados (vecinos.size()==0)
            ArrayList<Nodo> vacios = new ArrayList<>();
            for (Nodo n : nodos) {
                if (n.getVecinos().isEmpty()) vacios.add(n);
            }
            return vacios;
        }
    }
