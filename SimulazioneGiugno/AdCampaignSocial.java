public class AdCampaignSocial extends AdCampaign {
    //OVERVIEW: campagna pubblicitaria mediante post su social network, Tiene traccia del numero di visualizzazioni (nVis) e del numero di like (nLike) 

    //attributi
    double nVis, nLike;


    //costruttori
    public AdCampaignSocial(String nome, boolean aperta, double nVis, double nLike) throws NullPointerException, IllegalArgumentException {
        //EFFECTS: istanzia un AdCampaignSocial
        //      lancia NullPointerException se nome vuoto o null
        //      lancia IllegalArgumentException se valPerformance < 0 o > 1 
        //      lancia IllegalArgumentException se nLike > nVis
       
        super(nome, aperta);
        
        if (nLike > nVis) {
            throw new IllegalArgumentException("Num like deve essere < di num vis");
        }
        
        
        this.nVis = nVis;
        this.nLike = nLike;
        this.valPerformance = nLike/nVis;
        assert repOk();
    }

    //metodi
    public boolean repOk() {
        //(nLike) che saranno chiaramente meno di quelli che hanno visualizzato
        if (this.valPerformance < 0 || this.valPerformance > 1) {
            return false;
        }
        if (nLike > nVis)
            return false;

        return true;
        
    }

    //@Override
    public void update(double d1, double d2) throws CampaignClosedException {
        // EFFECTS: Se la campagna è aperta, i conteggi delle visualizzazioni e dei like possono essere incrementati, con il numero dei nuovi like (nLikeNew) e visualizzazioni (nVisNew), da aggiungere a quelli già inseriti precedentemente
        if (this.aperta == false) {
            throw new CampaignClosedException("Campagna chiusa, non è possibile aggiornarla");
        } else {
            this.nLike += d1;
            this.nVis += d2;
        }
        assert repOk();
    }
    




}
