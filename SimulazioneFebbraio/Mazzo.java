import java.util.ArrayList;
import java.util.Collections;

import javax.smartcardio.CardException;

public class Mazzo extends MazzoRidotto {
    // OVERVIEW: contiene tutte le 52 carte possibili, ovvero 13 valori per tutti e
    // 4 i semi

    //ESSENDO SOTTO TIPO NON HA ATTRIBUTI IN PIU RISPETTO A MAZZO RIDOTTO!!!!!  quindi non ha attributi in questo caso

    // costuttori
    public Mazzo() {
        // effects: riempie un mazzo con tutte e 52 le carte
        super();
        for (int i = 11; i <= 13; i++) {
            for (int j = 1; j <= 4; j++) {
                mazzo.add(new Carta(i, j));
            }
        }

        assert repOk();
    }

    @Override
    public void ordinaMazzo() {
        // MODIFIES: this
        // EFFECTS: ordina un mazzo

        this.mazzo.sort(null); // sort null usa il comparatore che gli abbiamo dato noi !!!!!!!!

    }

    @Override
    public void inserireCarta(Carta carta) throws CardExistsException, CardNotValidException {
        if (carta == null) {
            throw new CardNotValidException("Carta non puo essere nulla");
        }
        if (carta.getNum() < 1 || carta.getNum() > 13) {
            throw new CardNotValidException("Carta fuori range (num)");
        }

        if (carta.getSeme() < 1 || carta.getSeme() > 4) {
            throw new CardNotValidException("Carta fuori range (seme)");
        }

        if (this.mazzo.contains(carta)) { 
            System.out.println("Carta: " + carta + " nel mazzo: " + mazzo.indexOf(carta));
           
            throw new CardExistsException("Carta gia presente nel mazzo");
        }

        this.mazzo.add(carta);

    }


    @Override
    public boolean repOk() {
        for (Carta carta : mazzo) {
            if (carta == null) {
                return false;
            }
            if (carta.getNum() < 1 || carta.getNum() > 13) {
                return false;
            }

            if (carta.getSeme() < 1 || carta.getSeme() > 4) {
                return false;
            }
        }
        return true;
    }



}

// interfaccia non ha attributi es: solido.