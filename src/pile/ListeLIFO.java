package pile;

import java.util.ArrayList;
import java.util.List;

public class ListeLIFO <T> {
    protected List<T> liste;

    /**
     * Constructeur: initialise liste vide
     */
    public ListeLIFO (){
        this.liste = new ArrayList<>();
    }

    // Les méthodes

    public int size(){
        return liste.size();
    }
    public boolean isEmpty(){
        return this.size() == 0;
    }
    public void push(T objet){
        liste.add(objet);
    }

    public T pop(){
        if (!isEmpty()){
            int indexSommet = liste.size() - 1;
            T object = liste.get(indexSommet);
            liste.remove(indexSommet);
            return object;
        }
        System.out.println("La pile est vide !");
        return null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return ".";
        return size() + "";
    }
}
