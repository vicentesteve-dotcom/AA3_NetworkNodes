
import java.util.ArrayList;


public class Red {

    private ArrayList<Nodo> nodos;

    public Red(){
        nodos = new ArrayList<>();
    }

    void agregarNodo(Nodo n){
        if(!nodos.contains(n)){
            nodos.add(n);
        }

    }

    void connectar(Nodo a, Nodo b){
        a.connectar(b);
        b.connectar(a);

    }

    void mostrar(){
        System.out.println("=== GRAFO ===");
        for (Nodo n : nodos){
            System.out.println(n.getNombre() + " --> " + n.getVecinos());
        }
    }
}
