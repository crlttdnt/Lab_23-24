import java.util.ArrayList;
import java.util.Collections;

import javax.smartcardio.CardException;

public class Mazzo {
    //OVERVIEW: contiene tutte le 52 carte possibili, ovvero 13 valori per tutti e 4 i semi

    //attributi
    ArrayList<Carta> mazzo = new ArrayList<>();

    //costuttori
    public Mazzo() {
    //effects: riempie un mazzo con tutte e 52 le carte
       for (int i = 1; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                mazzo.add(new Carta(i, j));
            }
       } 
      
       assert repOk();
    }

    //metodi
    public void mischiaMazzo() {
        //MODIFIES: this
        //EFFECTS: mischia un mazzo casualmente
        
        Collections.shuffle(this.mazzo);

    }

    public void ordinaMazzo() {
        //MODIFIES: this
        //EFFECTS: ordina un mazzo 
        
        this.mazzo.sort(null); //sort null usa il comparatore che gli abbiamo dato noi !!!!!!!!

    }


    public void inserireCarta(Carta carta) throws CardExistsException, CardNotValidException {
        if (carta == null) {
           throw new CardNotValidException("Carta non puo essere nulla");
        }
        if (carta.get(num) < 1 || carta.get(num) > 13) {
            throw new CardNotValidException("Carta fuori range (num)");
        }
        
        if (carta.get(seme) < 1 || carta.get(seme) > 4) {
            throw new CardNotValidException("Carta fuori range (seme)");
        }
        

        if (this.mazzo.contains(carta)) {
            throw new CardExistsException("Carta gia presente nel mazzo");
        }
        
        this.mazzo.add(carta);

    }

    @Override
    public boolean repOk() {
        if (carta == null) {
            return false;
        }
        if (carta.get(num) < 1 || carta.get(num) > 13) {
            return false;
        }
        
        if (carta.get(seme) < 1 || carta.get(seme) > 4) {
            return false;
        }
        return true;
    }

/* 
 Fornire le funzionalita' di un iteratore standalone di carte, ovvero:
Verificare se vi sono ancora delle carte nel mazzo
Estrarre e restituire una carta dal mazzo (togliendola dal mazzo)
*/






}







//interfaccia non ha attributi