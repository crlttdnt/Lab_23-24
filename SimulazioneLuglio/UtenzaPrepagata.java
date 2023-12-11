public class UtenzaPrepagata extends Utenza {
    //OVERVIEW: utenza che ha un credito residuo di secondi di conversazione che viene decrementato.

    //attributi
    double creditoChiamataResiduo;

    //costruttore
    public UtenzaPrepagata(String numero, String nome, double creditoChiamataResiduo, double durataChiamataEffettuata) throws TempoEsauritoException {
        //effects: istanzia una nuova utenza prepagata
        //          lancia TempoEsauritoException se credito <= 0;
        super(numero, nome, durataChiamataEffettuata);
        if (creditoChiamataResiduo <= 0) 
            throw new TempoEsauritoException("Credito tempo residuo chiamate esaurito");
        
        this.creditoChiamataResiduo = creditoChiamataResiduo;

        assert repOk();
    }

    //metodi
    public void aumentaDurataChiamata(double tempo) {
        //modifies: this
        //effects: ricarica il credito residuo della chiamata
        this.creditoChiamataResiduo += tempo;

        assert repOk();
    }

    @Override
    public void reset() {
        
    }


    @Override
    public boolean repOk() {
        if (creditoChiamataResiduo <= 0) 
            return false;
        
            if (this.nome == null || nome.equals("")) {
                return false;
            }
        
            try {
                long n = Long.parseLong(this.numero);
            } catch (NumberFormatException e) {
                return false;
            }
        
            if (numero.length() != 10) 
                return false;
        


        return true;
    }

    @Override
    public String toString() {
        return "Utenza di " + this.nome + ", numero: " + this.numero + "; durata: " + this.durataChiamataEffettuata + ", credito: " + this.creditoChiamataResiduo;
    }
    
}
