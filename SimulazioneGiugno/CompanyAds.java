import java.util.ArrayList;
import java.util.Iterator;

public class CompanyAds implements Iterable<AdCampaign> {
    //OVERVIEW:indica un'azienda, identificata dal nome, e le sue campagne pubblicitarie
    /*
     * - Permette di inserire una nuova campagna pubblicitaria. Se tale campagna è già stata inserita,  viene     
     lanciata un'eccezione CampaignExistsException (unchecked)
        - Può restituire un iteratore alle campagne inserite, ordinate in base alla performance
     */
    //attributi
    String nomeAzienda;
    ArrayList<AdCampaign> azienda = new ArrayList<>();
    

    //costruttori
    public CompanyAds(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
        this.azienda = azienda;
    }


    //metodi
    public void inserisciCampagna(AdCampaign c) throws CampaignExistsException {
        if (azienda.contains(c)) {
            throw new CampaignExistsException("Campagna gia inserita");
        }

        azienda.add(c);
    }

    public ArrayList<AdCampaign> ordinaPerPerformance() {
        //modifies: this
        //effects: definisce l'ordine naturale delle campagne per performance
        ArrayList<AdCampaign> aziendaSorted = new ArrayList<>(azienda);
        aziendaSorted.sort(null);
        return aziendaSorted;

    }


    @Override
    public Iterator<AdCampaign> iterator() {
    //EFFECTS: Restituire un Iteratore delle tratte del Percorso
        
        return new Iterator<AdCampaign>() {

            ArrayList<AdCampaign> aziendaSorted = CompanyAds.this.ordinaPerPerformance();
            Iterator<AdCampaign> i = aziendaSorted.iterator();

           // @Override
            public boolean hasNext() {
                return i.hasNext();
            }

           // @Override
            public AdCampaign next() {
                return i.next();
            }
        };
    
            
    }


    @Override
    public String toString() {
        String ret = "";
        ret +=  "Campagne di " + nomeAzienda + ":\n";
        for (AdCampaign c : azienda) {
            System.out.println(c);
        }
        return ret;
    }
    


    


}
