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
            // Contar vulnerables alcanzables desde origen (BFS)
            int total_vuln = 0;
            for(Nodo v : origen.getVecinos()){
                if(v.getVulnerable() == true){
                    total_vuln++;
                }
            }
            return total_vuln;
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
                if (n.getVecinos().size() == 0) vacios.add(n);
            }
            return vacios;
        }
    }
