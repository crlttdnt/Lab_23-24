public class AdCampaignWebRestyling extends AdCampaign {
    //OVERVIEW: è una campagna pubblicitaria basata sul redesign del sito web. Tiene traccia del numero dei visitatori (nVis) e del tempo di visita medio (tVis) in minuti

    //attributi
    double nVis, tVis, tVisOld;

    //costruttori
    public AdCampaignWebRestyling(String nome, double valPerformance, boolean aperta, double nVis, double tVis, double tVisOld) throws NullPointerException, IllegalArgumentException {
        //EFFECTS: istanzia una AdCampaignWebRestyling
        //      lancia NullPointerException se nome vuoto o null
        //      lancia IllegalArgumentException se valPerformance < 0 o > 1 
        //      lancia 
        //alla creazione deve ricevere il tempo di visita medio per visitatore riferito al periodo prima dell'inizio della campagna (tVisOld) in minuti
        
        this.nVis = nVis;
        this.tVis = tVis;
        this.tVisOld = tVisOld;
        this.valPerformance = tVis/(tVis+tVisOld);
    }


    //metodi
    @Override
    public void uptade(double nVisNew, double tVisNew) throws CampaignClosedException {
        //Se la campagna è aperta, il conteggio dei visitatori può essere incrementato con il numero dei nuovi visitatori (nVisNew). Inoltre sarà indicato il tempo di visita medio per visitatore (tVisNew), riferito a questi nuovi visitatori. Il tempo di visita medio sarà aggiornato con la formula: ((nVis * tVis)+(nVisNew * tVisNew))/(nVis+nVisNew)
        if (this.aperta == false) {
            throw new CampaignClosedException("Campagna chiusa, non è possibile aggiornarla");
        } else {
            this.tVis = ((this.nVis * this.tVis)+(nVisNew * tVisNew))/(nVis+nVisNew);
        }


        assert repOk();
    }

    @Override
    public boolean repOk() {
        if (valPerformance < 0 || valPerformance > 1) {
            return false;
        }
        return true;
        //DA FINIRE
    }
}
