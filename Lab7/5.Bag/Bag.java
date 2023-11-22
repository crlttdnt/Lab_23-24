import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bag<E> implements Iterable<E> { // Iterable<E> ossia itera su E, Bag<E> una bag di E
    // OVERVIEW: modella un bag/multiset generico

    // attributi:
    HashMap<E, Integer> elems = new HashMap<>();

    // metodi
    public void insert(E elem) throws NullPointerException {
        // MODIFIES: this
        // EFFECTS: inserisce elem in this
        // se elem è null lancia NullPointerException
        if (elem == null)
            throw new NullPointerException("Elem null");

        Integer currentCount = elems.putIfAbsent(elem, 1);

        if (currentCount != null)
            elems.replace(elem, currentCount);

        assert repOk();
    }

//@SuppressWarnings("unchecked")
    public E pick() throws NoSuchElementException {
        // EFFECTS: restituisce un elemento della Bag
        // se bag vuota lancia NoSuchElemetException

        if (this.size() == 0)
            throw new NoSuchElementException("bag empty");

        return (E) (elems.keySet().toArray())[0];
    }

    public void remove(E elem) throws NoSuchElementException, NullPointerException {
        // MODIFIES: this
        // EFFECTS: rimuove elem da this
        // se elem non in this lancia NoSuchElemetException
        // se elem == null lancia NullPointerException

        if (elem == null)
            throw new NullPointerException("Elem null");

        if (!this.contains(elem))
            throw new NoSuchElementException("Elem non presente");

        Integer currentCount = elems.get(elem);

        if (currentCount == 1)
            elems.remove(elem);
        else
            elems.replace(elem, currentCount - 1);

    }

    public boolean contains(E elem) throws NullPointerException {
        // EFFECTS: restituisce true se elem in this, false altrimenti.
        // se elem è null lancia NullPointerException
        if (elem == null)
            throw new NullPointerException("Elem null");

        if (elems.containsKey(elem))
            return true;

        return false;
    }

    public int count(E elem) throws NullPointerException {
        // EFFECTS: restituisce il numero di elem in this
        // se elem è null lancia NullPointerException

        if (elem == null)
            throw new NullPointerException("Elem null");

        Integer currentCount = elems.get(elem);

        if (currentCount == null)
            return 0;

        return currentCount;

    }

    public int size() {
        // EFFECTS: restituisce il numero di elementi TOTALE
        int totale = 0;
        for (E elem : elems.keySet()) {
            totale += elems.get(elem);
        }

        return totale;
    }

    public int sizeUnique() {
        // EFFECTS: restituisce il numero di elementi UNICI
        return elems.size();
    }

    @Override
    public String toString() {
        String ret = "Bag - elements: [ ";
        for (E elem : this) {
            ret += elem + " ";
        }
        ;

        return ret + "]";

    }

    public boolean repOk() {
        for (E elem : elems.keySet()) {
            if (elem == null)
                return false;
            if (elems.get(elem) <= 0)
                return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Iterator<E> keys = elems.keySet().iterator();

            E current = null;

            int currCount = 1;

            @Override
            public E next() throws NoSuchElementException {
                if (!(this.hasNext()))
                    throw new NoSuchElementException("no more elems");

                if (current != null && elems.get(current) > currCount)
                    currCount++;
                else {
                    current = keys.next();
                    currCount = 1;
                }

                return current;
            }

            @Override
            public boolean hasNext() {
                if (current != null && elems.get(current) > currCount) // sono su un elemento e me ne sono rimasti
                                                                       // ancora
                    return true;
                else if (keys.hasNext())
                    return true;

                return false;
            }

        };
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        if (args[0].equals("String")) {
            Bag<String> b = new Bag<>();

            while (s.hasNext()) {
                b.insert(s.next());
            }

            System.out.println(b);

        } else if (args[0].equals("Double")) {
            Bag<Double> b = new Bag<>();

            while (s.hasNextDouble()) {
                b.insert(s.nextDouble());
            }

            System.out.println(b);

        } else if (args[0].equals("Integer")) {
            Bag<Integer> b = new Bag<>();

            while (s.hasNextInt()) {
                b.insert(s.nextInt());
            }

            System.out.println(b);
        }

    }

}
