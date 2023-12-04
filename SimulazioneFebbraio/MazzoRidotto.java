public class MazzoRidotto{
    //OVERVIEW: contiene una versione ridotta del mazzo (carte con i valori [A=1,2,3,4,5,6,7,8,9,10] dei 4 semi)

    //attributi
    ArrayList<Carta> mazzo = new ArrayList<>();

    //costuttori
    public Mazzo() {
    //effects: riempie un mazzo ridotto(num fino a 10)
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 4; j++) {
                mazzo.add(new Carta(i, j));
            }
        } 
    
        assert repOk();
    }

    //metodi
    @Override
    public boolean repOk() {
        if (carta == null) {
            return false;
        }
        if (carta.get(num) < 1 || carta.get(num) > 10) {
            return false;
        }
        
        if (carta.get(seme) < 1 || carta.get(seme) > 4) {
            return false;
        }
        return true;
    }

    public void ordinaMazzo() {
        mazzo.sort(new Comparator<Carta>() {

            compare()

        });
    }





}
