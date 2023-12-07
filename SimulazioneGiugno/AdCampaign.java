public abstract class AdCampaign implements Comparable {
    //OVERVIEW: definisce una campagna pubblicitaria, identificata da un nome.

    //attributi
    String nome;
    double valPerformance; //Una campagna può restituire un valore di performance (numero decimale tra 0 e 1 inclusi)
    boolean aperta; //true se aperta, false se chiusa


    //costruttori
     public AdCampaign(String nome, double valPerformance, boolean aperta) throws NullPointerException, IllegalArgumentException {
        //EFFECTS: istanzia un AdCampaign, una campagna viene creata aperta
        //      lancia NullPointerException se nome vuoto o null
        //      lancia IllegalArgumentException se valPerformance < 0 o > 1 
        
        this.nome = nome;
        this.valPerformance = valPerformance;
        this.aperta = true;

        assert repOk();
    }


    //metodi:
    @Override
    public int compareTo(Object o) {
        // Due campagne sono considerate uguali se hanno lo stesso nome
        if (this.nome == o.nome) {
            return true;
        }
        return false;
    }

    @Override
    public boolean repOk() {
        if (valPerformance < 0 || valPerformance > 1) {
            return false;
        }
        return true;
    }


    //Le campagne possono essere naturalmente ordinate per il loro valore di performance
    @Override
    public int compare(Object o) {
        if (this.valPerformance < o.valPerformance) 
            return -1;
        
        if (this.valPerformance > o.valPerformance)
            return 1;
    }


    public abstract void update() throws CampaignClosedException;

    public void close() {
        this.aperta = false;
    }
    

/*
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
 */


    public String getNome() {
        return nome;
    }

    public double getValPerformance() {
        return valPerformance;
    }

    public boolean isAperta() {
        return aperta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValPerformance(double valPerformance) {
        this.valPerformance = valPerformance;
    }

    public void setAperta(boolean aperta) {
        this.aperta = aperta;
    }

    


   

}
