public class Bag<E> implements Iterable<E> { //Iterable<E> ossia itera su E, Bag<E> una bag di E
//OVERVIEW: modella un bag/multiset generico

//metodi
    public void insert(E elem) throws NullPointerException {
    //MODIFIES: this
    //EFFECTS: inserisce elem in this
    //         se elem è null lancia NullPointerException
        if (elem == null) {
            throw new NullPointerException("Elem null");
            
        }
    }


    public E pick() throws NoSuchElemetException  {
    //EFFECTS: restituisce un elemento della Bag
    //         se bag vuota lancia NoSuchElemetException

    }

    public remove(E elem) throws NoSuchElemetException {
    //MODIFIES: this
    //EFFECTS: rimuove elem da this
    //         se elem non in this lancia NoSuchElemetException

    }

    public boolean contains(E elem) {
    //EFFECTS: restituisce true se elem in this, false altrimenti.
    //         se elem è null lancia NullPointerException 

    }

    public int count(E elem) {
    //EFFECTS: restituisce il numero di elem in this
    //         se elem è null lancia NullPointerException 

    }

    public int size() {
    //EFFECTS: restituisce il numero di elementi totale 
    
    @Override
    public String toString() {

    }

    public boolean repOk() {

    }

    @Override
    public Iterator<E> Iterable {

    }


}
