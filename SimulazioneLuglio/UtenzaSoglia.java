public class UtenzaSoglia extends UtenzaPrepagata {
    //OVERVIEW: utenza che ha un numero fisso settimanale di secondi disponibili, (corrispondente ad una soglia inserita alla creazione dell'utenza), che si resettano ogni settimana (i secondi non usati sono persi).

    //attributi
    double creditoChiamataSettimanale;

    //costruttore
    public UtenzaSoglia(String numero, String nome, double creditoChiamataSettimanale, double durataChiamataEffettuata) throws TempoEsauritoException {
        //effects: istazia una nuova UtenzaSoglia
        //          : lancia TempoEsauritoException se  <= 0;
        super(numero,nome, durataChiamataEffettuata, 0);


        if (this.creditoChiamataResiduo <= 0) {
            throw new TempoEsauritoException("Credito tempo residuo chiamate esaurito");
        }

        this.creditoChiamataSettimanale = creditoChiamataSettimanale;

        assert repOk();
    }

    //metodi
    @Override
    public boolean repOk() {
        if (creditoChiamataSettimanale <= 0) 
            return false;
        if (this.creditoChiamataResiduo <= 0)
            return false;
        
            if (this.nome == null || nome.equals("")) {
                return false;
            }
        
            try {
                int n = Integer.parseInt(this.numero);
            } catch (NumberFormatException e) {
                return false;
            }
        
            if (numero.length() != 10) 
                return false;
        


        return true;
    }

    @Override
    public void reset() {
        //modifies: this
        //effects: azzera il creditoChiamataSettimanale
        this.creditoChiamataSettimanale = 0;
    }


//Utenza di Ajeje Brazorf, numero: 0987654321; durata: 16, credito: 10, soglia: 20
    @Override
    public String toString() {
        return "Utenza di " + this.nome + ", numero: " + this.numero + "; durata: " + this.durataChiamataEffettuata + ", credito: " + this.creditoChiamataResiduo + ", soglia: " + this.creditoChiamataSettimanale;
    }




}

