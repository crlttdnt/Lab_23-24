public class AdCampaignSocial extends AdCampaign {
    //OVERVIEW: campagna pubblicitaria mediante post su social network, Tiene traccia del numero di visualizzazioni (nVis) e del numero di like (nLike) 

    //attributi
    int nVis, nLike;


    //costruttori
    public AdCampaignSocial(String nome, double valPerformance, boolean aperta, int nVis, int nLike) {
        super(nome, valPerformance, aperta);
        this.nVis = nVis;
        this.nLike = nLike;
        this.valPerformance = nLike/nVis;
    }

    //metodi
    public boolean repOk() {
        //(nLike) che saranno chiaramente meno di quelli che hanno visualizzato
    }


}
