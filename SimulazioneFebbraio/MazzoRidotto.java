import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.smartcardio.CardException;

public class MazzoRidotto implements Iterator<Carta> {
    //OVERVIEW: contiene una versione ridotta del mazzo (carte con i valori [A=1,2,3,4,5,6,7,8,9,10] dei 4 semi)

    //attributi
    ArrayList<Carta> mazzo = new ArrayList<>();

    //costuttori
    public MazzoRidotto() {
    //effects: riempie un mazzo ridotto(num fino a 10)
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 4; j++) {
                mazzo.add(new Carta(i, j));
            }
        } 
    
        assert repOk();
    }

    //metodi
    public boolean repOk() {
        for (Carta carta : mazzo) {
            if (carta == null) {
            return false;
            }
            if (carta.getNum() < 1 || carta.getNum() > 10) {
                return false;
            }
            
            if (carta.getSeme() < 1 || carta.getSeme() > 4) {
                return false;
            }
            
        }
        return true;
        
    }

    public void mischiaMazzo() {
        //MODIFIES: this
        //EFFECTS: mischia un mazzo casualmente
        
        Collections.shuffle(mazzo);

    }

    public void ordinaMazzo() {
        mazzo.sort(new Comparator<Carta>() {

            @Override
            public int compare(Carta c1, Carta c2) {
                if (c1.getSeme() == c2.getSeme()) {
                    if (c1.getNum() < c2.getNum()) 
                        return -1;
                    if(c1.getNum() > c2.getNum())
                        return 1;
                }
                    
                if (c1.getSeme() < c2.getSeme())
                    return -1;
                if (c1.getSeme() > c2.getSeme())
                    return 1;
                
                return 0;
            }

        });
    }


    public void inserireCarta(Carta carta) throws CardExistsException, CardNotValidException {
        if (carta == null) {
           throw new CardNotValidException("Carta non puo essere nulla");
        }
        if (carta.getNum() < 1 || carta.getNum() > 10) {
            throw new CardNotValidException("Carta fuori range (num)");
        }

        if (carta.getSeme() < 1 || carta.getSeme() > 4) {
            throw new CardNotValidException("Carta fuori range (seme)");
        }
        
        if (mazzo.contains(carta)) {
            throw new CardExistsException("Carta gia presente nel mazzo");
        }
        
        this.mazzo.add(carta);

    }

    @Override
    public boolean hasNext() {
        //effects: Verificare se vi sono ancora delle carte nel mazzo
        if (mazzo.size() == 0) 
            return false;
        
        return true;
        
    }

    @Override
    public Carta next() {
        // effetcs: Estrarre e restituire una carta dal mazzo (togliendola dal mazzo)
        return mazzo.remove(0);
        
    }

    @Override
    public String toString() {
        String ret = "";
        for (Carta carta : mazzo) {
            ret += carta + "\n";           
        }
        return ret;
    }

    public int size() {
        return mazzo.size();
    }

    
}
