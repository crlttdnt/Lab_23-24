import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //leggere da riga di comando il nome dell'azienda e poi, da standard input, una serie di righe

        String nomeAzienda = args[0];

        //ArrayList<AdCampaign> azienda = new ArrayList<>();
        
        double tVisOld  = 0;

        Scanner s = new Scanner(System.in);

        CompanyAds azienda =  new CompanyAds(nomeAzienda);

        System.out.println("Inserisci o aggiorna campagne:");

        try {
            while (s.hasNextLine()) {
                String[] str = s.nextLine().split(" ");
                //NomeCampagna TipoCampagna parametri + ...
                String NomeCampagna = str[0];
                String TipoCampagna = str[1]; //tipoCampagna può essere Social o WebRestyle  
                AdCampaign campagna = null;
                if (str[2].equals("open")) {
                  
                    if (TipoCampagna.equals("WebRestyle")) {
                        tVisOld = Double.parseDouble(str[3]);
                         campagna = new AdCampaignWebRestyling(NomeCampagna, true, 0, 0, tVisOld);
                    } else if (TipoCampagna.equals("Social")) {
                         campagna = new AdCampaignSocial(NomeCampagna, true, 0, 0);
                    }   

                    azienda.inserisciCampagna(campagna);

                } else if (str[2].equals("close")) {
                    campagna.close();
                } else if (str[2].equals("update")) {
                    double n1 = Double.parseDouble(str[3]);
                    double n2 = Double.parseDouble(str[4]);
                    campagna.update(n1, n2);
                }
            }
        } catch (NullPointerException | IllegalArgumentException | CampaignClosedException | CampaignExistsException e) {
           System.out.println(e.getMessage());
        }

        System.out.println(azienda);

        

    }
}
