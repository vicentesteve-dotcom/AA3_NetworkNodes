import java.util.ArrayList;

public class Nodo {
    private String nombre;

    private ArrayList <Nodo> vecinos;    

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.vecinos = new ArrayList<>();
    }
    
    public void connectar(Nodo otro){
        if(!vecinos.contains(otro)){
            vecinos.add(otro);
        }
    }
    
    public String getNombre(){
        return nombre;
    }

    public String getVecinos(){
        String tmp = "";

        for(Nodo v : vecinos){
            tmp += "- [" + v.getNombre() + "] "; 
        }
        return tmp;
    }
}
