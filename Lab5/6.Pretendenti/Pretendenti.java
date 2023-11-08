import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pretendenti implements Iterable<Integer> {
    //OVERVIEW: modellare una lista di pretendenti da selezionare

    //attributi
    ArrayList<Integer> pretendenti;


    //costruttori
    public Pretendenti(int n) throws IllegalArgumentException {
        //MODIFIES: this
        //EFFECTS: inizializza this con n pretendenti, a ognuno viene assegnato un numero
        //lancia IllegalArgumentException se n è negativo o 0

        if (n <= 0) {
            throw new IllegalArgumentException("Il numero di pretedenti non può essere <= 0");
        }

        this.pretendenti = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            this.pretendenti.add(i);
        }

        assert repOK();

    }

    //metodi
    public int getVincitore() throws IllegalStateException {
        //EFFECTS: restituisce l'ultimo pretendente rimasto, come vincitore
        //lancia IllegalStateException se la lista contiene più di un pretendente
        if (this.pretendenti.size() != 1) {
            throw new IllegalStateException("Deve esserci un solo vincitore");
        }

        return this.pretendenti.get(0);


    }

    @Override
    public String toString() {
        //EFFECTS: restituisce la stringa dei pretendenti
        String ret = "Pretendenti:";
        for (int i : this.pretendenti) {
            ret += " " + i;
        }
        
        return ret;
    }

   
    public boolean repOK() {
        for (Integer i : pretendenti) {
            if ( i == null || i <= 0) {
                return false;
            }
            return true;
        }
        return false;
    }



    @Override
    public Iterator<Integer> iterator() {
        //EFFECTS: restituisce un iteratore che seleziona il pretendente da elimimnre e poi salta di tre
        //MODIFIES: modifica la lista dei pretendenti eliminado quello selezionato
        return new Iterator<Integer>() {
            //OVERVIEW: Iteratori che conta ogni volta tre pretendenti e ne elimina uno ogni tre
            
            boolean direction = true; 
            boolean removed = true; //senza aver fatto la hasnext non faccio remove
            int current = 0;


            @Override
            public boolean hasNext() {
                //EFFECTS: restituisce true se ci sono pretendenti eliminabili e false altrimenti.
                return Pretendenti.this.pretendenti.size() > 1;
              
            }

            @Override
            public Integer next() throws NoSuchElementException {
                //MODIFIES: this (è indice non this.pretendenti)
                //EFFECTS: restituisce il prossimo pretendente da eliminare, aggiorna l'indice, aggiorna la direzione e imposta il flag removed a false
                //lancia NoSuchElementException se non ci sono piu elementi

                if(!(this.hasNext())) 
                    throw new NoSuchElementException("Non ci sono più pretendenti");
                
                if (this.direction)
                    this.current += 2;
                else 
                    this.current -= 2;
                
                if (this.current >= Pretendenti.this.pretendenti.size() - 1) {
                    this.current = 2*(Pretendenti.this.pretendenti.size() - 1) - (this.current);
                    this.direction = false;
                }

                if (this.current <= 0) {
                    this.current = - this.current;
                    this.direction = true;
                }

                removed = false;
                
                return Pretendenti.this.pretendenti.get(this.current);
            }

            @Override
            public void remove() throws IllegalStateException {
               //MODIFIES: this.pretendenti, this (indice)
               //EFFECTS: rimuove il pretendente selezionato da next() e aggiorna l'indice.
               //lancia IllegalStateException se sto eliminando senza aver fatto prima una next()

               if (this.removed) 
                    throw new IllegalStateException("Non si può eliminare se prima non viene selezionato un nuovo pretendente");

                Pretendenti.this.pretendenti.remove(this.current);
                this.removed = true;

                if (!(this.direction))
                    this.current --;

                if (this.current > Pretendenti.this.pretendenti.size() - 1) {
                    this.current --;
                }

                if (this.current == Pretendenti.this.pretendenti.size() - 1)
                    this.direction = false;
                if (this.current == 0) 
                    this.direction = true;

                assert repOK();
            }

            @Override
            public String toString() {
                /*  MODO PROLISSO:
                if (this.direction) {
                    return "Si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione avanti";
                } else {
                    return "Si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione indietro";
                }*/
               
                //MODO VELOCE PIU BELLO
                String dirString = direction ? "avanti" : "indietro";
                return "Si conta da " + Pretendenti.this.pretendenti.get(this.current) + " direzione " + dirString;

            }

            
            
        };


    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Pretendenti p = new Pretendenti(n);
        Iterator<Integer> i = p.iterator(); //i itera su oggetto p appena creato

        while (i.hasNext()) {
            System.out.println(p);
            System.out.println(i);
            System.out.println("Elimino " + i.next());;
            i.remove();
        }

        System.out.println("Il pretendente vincitore e " + p.getVincitore());
    }
}
